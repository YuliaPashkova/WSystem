package WORK;
import GUI.GAccount;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import static WORK.Methods.getColumnName;
/*
 * Created by Юлия on 02.05.2017.
 */
public class Account {
    public static String names_indexes[];
    public static Account account;
    public static String error;//текст ошибки
    public static String FIO;
    public static double balance;
    public static Date date_contract;
    public static int num_contract;
    public static String owner_flat;
    public static String cons_type;
    public static String telephone;
    public static String acc_status;
    public static int kpp;
    public static long pay_account;
    public static long num_cert;
    public static long INN;
    public static String name_company;
    public static int num_account;
    private static Statement statement;
    private static int adres;
    private static  int bank;

    /*
   Метод формирует запрос для отображения данных лицевого счета в форму,
   по номеру лицевого счета (полученного из таблицы)
   Принимает номер лицевого счета и тип абонента
   */
    public static void showAccount(String num_acc, String cons_type) throws Exception {
        String query;
        if (cons_type.equals("ФИЗИЧЕСКОЕ ЛИЦО")) {//для физ.лица
            query = "select * from account where num_account=" + num_acc;
            receivingQueryForSearch(query, false, true);
        } else {//для юр.лица
            query = "select * from account JOIN account_company ON account.num_account=account_company.num_account and account.num_account=" + num_acc;
            receivingQueryForSearch(query, false, false);
        }
    }

    /*
    Метод формирует запрос для поиска лицевого счета по данным,полученным из формы
    Принимает массив с данными
    */
    public static int searchAccount(String data[]) throws Exception {
        account = null;
        //сначала нужно проверить,заполнено хотя бы одно поле из адреса (улица,дом,кв,корпус,индекс)
        //если заполнено,нужно выполнить запрос поиска по таблице adress и получить подходящие id_adress
        //затем искать в таблице account по введенным полям и id_adress
        //затем нужно проверить,заполнено ли хотя бы одно поле для юр.лиц
        //если заполнено, то составить запрос на объединение двух таблиц через JOIN
        String column_account[] = getColumnName("watermeter.account").split(" ");//получение имен колонок таблицы account
        //обработка адреса
        String address[] = new String[6];
        System.arraycopy(data, 10, address, 0, 6);//копирование полей адреса
        data[5] = checkAddress(address);//проверка,заполнено ли хотя бы одно поле адреса и формирование индексов подходящих адресов
        if (data[5].equals("not found")) return -1;//ничего не найдено,дальше нет смысла проверять
        //если поля для юр.лиц не заполнены
        if (data[16] == null && data[17] == null && data[18] == null && data[19] == null && data[20] == null && data[21] == null) {
            //начало запроса
            String query = "select * from  watermeter.account where ";
            for (int i = 0; i < column_account.length; i++)
                if (i != 5 && i != 1)//5- поле адреса,оно добавится в конце,1- ФИО,добавится в конце
                    if (data[i] != null)
                        query += column_account[i] + "='" + data[i] + "'" + " and ";
            if (!Objects.equals(data[5], "empty"))
                query += "adres IN " + data[5] + " and "; //если адрес не пуст,добавляем в запрос
            if (data[1] != null) query += "FIO like '%" + data[1] + "%'";
            if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
            return receivingQueryForSearch(query, true, true); //0-найдено,-1-не найдено
        }
        //если заполнено хотя бы одно поле для юр.лиц
        else {
            //начало запроса
            String query = "select * from  account JOIN account_company ON account.num_account=account_company.num_account WHERE ";
            //формирование запроса как для физ.лиц
            for (int i = 0; i < column_account.length; i++)
                if (i != 5 && i != 1)//5- поле адреса,оно добавится в конце,1- ФИО,добавится в конце
                    if (data[i] != null)
                        query += "account." + column_account[i] + "='" + data[i] + "'" + " and ";
            if (!Objects.equals(data[5], "empty"))
                query += "adres IN " + data[5] + " and "; //если адрес не пуст,добавляем в запрос
            if (data[1] != null) query += "FIO like '%" + data[1] + "%'";
            //получение индекса банка
            if (data[16] != null)
                data[16] = Integer.toString(getIndex(data[16], 4));//теперь вместо названия банка, хранится его индекс
            //получение имен колонок таблицы account_company
            String column_account_comp[] = getColumnName("watermeter.account_company").split(" ");
            int i, j;//переменные цикла
            //i - пробег по column_account_company, c 1 - так как первая колонка это num_account и она уже есть в запросе
            //j-пробег по данным с 16 по 21 ячейку (поля для юр.лиц)
            //формирование запроса для юр.лиц
            for (i = 1, j = 16; i < column_account_comp.length && j < data.length; i++, j++)
                if (j != 21)//21- название компании,добавиться в конце
                    if (data[j] != null)
                        query += "account_company." + column_account_comp[i] + "='" + data[j] + "'" + " and ";
            if (data[21] != null) query += "account_company.name_company like '%" + data[21] + "%'";
            if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());

            account = new Account();
            return receivingQueryForSearch(query, true, false);
        }
    }

    /*
    Метод ищет индексы подходящих адресов (из таблицы adres)
    Принимает все данные,необходимые для поиска (улица,дом,кв....)
    Возвращает массив найденных индексов
     */
    private static String checkAddress(String addres[]) throws Exception {
        int id_district, id_street, id_index;
        int count = 0;//счетчик нулевых полей
        String indexes = "(";//здесь будут хранится все подходящие индексы адресов (результат метода)
        String query = "select id_adres from  watermeter.adres where ";
        for (int i = 0; i < 6; i++)
            if (!(addres[i] == null))//если i-ое поле заполнено
                switch (i) {
                    case 0://район
                        id_district = getIndex(addres[0], 0);//получаем индекс района, передаем название района
                        query += "id_district = " + id_district + " and ";
                        break;
                    case 1://улица
                        id_street = getIndex(addres[1], 1);//получаем индекс улицы, передаем название улицы
                        query += "id_street = " + id_street + " and ";
                        break;
                    case 2://дом
                        query += "house = " + addres[2] + " and ";
                        break;
                    case 3://корпус
                        query += "corpus = " + addres[3] + " and ";
                        break;
                    case 4://квартира
                        query += "flat = " + addres[4] + " and ";
                        break;
                    case 5:
                        id_index = getIndex(addres[5], 2);//получаем индекс индекса, передаем индекс
                        query += "id_index = " + id_index;
                        break;
                }
            else {
                count++;
            }
        if (count == 6)//все пусто
            return "empty";//пустые поля адреса
        //обрезаем последний and
        if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
        //выполняем запрос
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                indexes += Integer.toString(resSet.getInt("id_adres")) + ",";
            }
            //обрезаем последнюю запятую
            if (indexes.endsWith(",")) indexes = indexes.substring(0, indexes.length() - ",".length());
            //добавляем скобку для IN
            indexes += ")";
            return indexes;
        }
        statement.close();
        return "not found";//по данному адресу ничего не найдено

    }

    /*
    * Метод формирует и выполняет запрос на получение индексов района,улицы,индекса,банка
    * Принимает строкое значеие и флаг what: 0 - район, 1 - улица,2 - индекс,3 - банк
    * Возвращает индекс района,улицы,индекса,банка
    * */
    private static int getIndex(String data, int what) throws Exception {
        String query;
        int ind = -1;//здесь будет хранится полученный индекс

        if (what == 0) query = "select id from watermeter.cat_district where district = \"" + data + "\"";
        else if (what == 1) query = "select id from watermeter.cat_street where street = \"" + data + "\"";
        else if (what == 2) query = "select id from watermeter.cat_index where indx = " + data;
        else query = "select id from watermeter.cat_bank where bank = \"" + data + "\"";

        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                ind = resSet.getInt("id");
            }
        }
        statement.close();
        return ind;
    }

    /*
    * Метод удаляет аккаунт с номером счета num_acc
    * */
    public static void deleteAccount(String num_acc) throws SQLException {
        String query = "delete from account where num_account=" + num_acc;
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод анализирует новые данные и изменяет в БД
    * Возвращает
    * 0 - без ошибок
    */
    public static int changeData(String[] new_data) throws Exception {
        int id_adres = -1;
        boolean changed_adres = false;//флаг изменения адреса (true - адрес был изменен)
        boolean changed_fieldsAcc = false;//флаг изменения полей для физ.лица (true - хотя бы одно поле было изменено)
        boolean changed_fieldsComp = false;//флаг изменения полей для юр.лица (true - хотя бы одно поле было изменено)

        String new_adres[] = new String[6];
        String new_data_acc[] = new String[10];//данные из полей для физ.лица

        new_adres[0] = new_data[19];//район
        new_adres[1] = new_data[6];//улица
        new_adres[2] = new_data[7];//дом
        new_adres[3] = new_data[9];//квартира
        new_adres[4] = new_data[8];//корпус
        new_adres[5] = new_data[10];//индекс

        for (String new_adre : new_adres)
            if (new_adre.contains("*")) {
                changed_adres = true;
                break;
            }
        if (changed_adres) {//если хотя бы одно поле адреса было изменено
            int check_adres;
            int result = checkAdresFields(new_adres);//проверка поля адреса на содержимое
            if (result == 0) {//если нет ошибки
                for(int i=0;i<new_adres.length;i++)new_adres[i]=new_adres[i].replaceAll("\\*","");
                check_adres = getIdFromAdres(new_adres);
                if (check_adres != -1)  id_adres = check_adres;//если такой адрес уже есть в системе
                else id_adres = addNewAdres(new_adres);//иначе добавляем новый
                changeAdres(new_data[0], String.valueOf(id_adres));//изменяем адрес
            }
            else return result;//вернуть ошибку
        }

        //работа с полями для физ.лица,сборка данных в массив,удобный для использования
        new_data_acc[0] = new_data[0];//номер лицевого счета
        new_data_acc[1] = new_data[1] + " " + new_data[2] + " " + new_data[3];//ФИО
        new_data_acc[2] = new_data[4];//баланс
        new_data_acc[3] = new_data[22];//дата договора
        new_data_acc[4] = new_data[5];//номер договора
        new_data_acc[5] = Integer.toString(id_adres);//адрес (к этому моменту он уже поменялся)
        new_data_acc[6] = new_data[12];//владелец
        new_data_acc[7] = new_data[20];//тип потребителя
        new_data_acc[8] = new_data[11];//телефон
        new_data_acc[9] = new_data[21];//статус аккаунта

        for (String aNew_data_acc : new_data_acc)
            if (aNew_data_acc.contains("*")) {
                changed_fieldsAcc = true;
                break;
            }
        if (changed_fieldsAcc) {//если хотя бы одно поле  было изменено
            int result = checkAccountFields(new_data_acc);//проверка полей для физ. лица на содержимое
            if (result == 0) changeDataAcc(new_data_acc);//изменение полей для физ.лица
            else return result;
        }
        if (new_data_acc[7].equals("ЮРИДИЧЕСКОЕ ЛИЦО")) {
            String new_data_comp[] = new String[7];//данные из полей для юр.лица
            new_data_comp[0] = new_data[0];//номер лицевого счета
            new_data_comp[1] = new_data[15];//банк
            new_data_comp[2] = new_data[18];//кпп
            new_data_comp[3] = new_data[16];//расчетный счет
            new_data_comp[4] = new_data[14];//номер сертификата
            new_data_comp[5] = new_data[17];//инн
            new_data_comp[6] = new_data[13];//название компании

            for (String aNew_data_comp : new_data_comp)
                if (aNew_data_comp.contains("*")) {
                    changed_fieldsComp = true;
                    break;
                }
            if (changed_fieldsComp) {//если хотя бы одно поле  было изменено
                int result = checkAccountCompFields(new_data_comp);//проверка полей для юр.лица на содержимое
                //тут должна быть проверка на содержимое полей
                if (result == 0) changeDataAccCompany(new_data_comp);//изменение полей для юр.лица
                else return result;
            }
        }
        return 0;
    }

    /*
     * Метод проверяет содержимое полей для юр.лица на корректность
     * Возващает 0 - если нет ошибок
     * -1 - если ошибка
     * */
    private static int checkAccountCompFields(String[] new_data_comp) {
        String s;
        for (int i = 1; i < new_data_comp.length; i++)// 0-номер счета
            if (new_data_comp[i].contains("*")) {//если поле было изменено
                s = new_data_comp[i].replaceAll("\\*", "");//убираем звездочку
                switch (i) {
                    case 1://банк
                        if (s.equals("")) {error = "Поле \"Банк плательщика\" не может быть пустым!";return -1;}
                        if (s.length() > 50) {error = "Поле \"Банк плательщика\" содержит много символов!";return -1;}
                        break;
                    case 2://кпп
                        if (s.equals("")) {error = "Поле \"КПП\" не может быть пустым!";return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"КПП\" должно содержать только цифры!";return -1;}
                        if (s.length() != 9) {error = "Поле \"КПП\" должно содержать 9 символов!";return -1;}
                        break;
                    case 3://расчетный счет
                        if (s.equals("")) {error = "Поле \"Расчетный счет\" не может быть пустым!";return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"Расчетный счет\" должно содержать только цифры!";return -1;}
                        if (s.length() != 18) {error = "Поле \"Расчетный счет\" должно содержать 18 символов!";return -1;}
                        break;
                    case 4://номер сертификата
                        if (s.equals("")) {error = "Поле \"№ свидетельства\" не может быть пустым!";return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"№ свидетельства\" должно содержать только цифры!";return -1;}
                        if (s.length() != 15) {error = "Поле \"№ свидетельства\" должно содержать 15 символов!";return -1;}
                        break;
                    case 5://инн
                        if (s.equals("")) {error = "Поле \"ИНН\" не может быть пустым!";return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"ИНН\" должно содержать только цифры!";return -1;}
                        if (s.length() != 10) {error = "Поле \"ИНН\" должно содержать 10 символов!";return -1;}
                        break;
                    case 6://название компании
                        if (s.equals("")) {error = "Поле \"Название компании\" не может быть пустым!";return -1;}
                        if (s.length() > 45) {error = "Поле \"Название компании\" содержит много символов!";return -1;}
                        break;
                }
            }
        return 0;
    }

    /*
    * Метод проверяет содержимое полей для физ.лица на корректность
    * Возващает 0 - если нет ошибок
    * -1 - если ошибка
    * */
    private static int checkAccountFields(String[] new_data_acc) throws ParseException {
        String s;
        for (int i = 1; i < new_data_acc.length; i++)// 0-номер счета, 7 - тип потребителя,5- адрес,9 - статус аккаунта, их проверять не надо
            if (new_data_acc[i].contains("*")) {//если поле было изменено
                s = new_data_acc[i].replaceAll("\\*", "");//убираем звездочку
                switch (i) {
                    case 1://ФИО
                        String fio[] = s.trim().split("\\s\\s*");//длина должна быть равна 3 ( ФИО)
                        if ((s.replaceAll(" ", "").equals("")) || fio.length != 3) {error = "Поле \"ФИО\" не может быть пустым!";return -1;}
                        if (s.length() > 100) {error = "Поле \"ФИО\" содержит много символов!";return -1;}
                        if (!Methods.isLetter(s)) {error = "Поле \"ФИО\" должно содержать только буквы!";return -1;}
                        break;

                    case 2://баланс
                        if (s.equals("")) {error = "Поле \"Баланс\" не может быть пустым!";return -1;}
                        if (s.contains(",")) {new_data_acc[i] = new_data_acc[i].replaceAll(",", ".");s = s.replaceAll(",", ".");}
                        if (s.equals(".")) {error = "Неправильный формат поля \"Баланс\"!";return -1;}
                        if (!Methods.isDigit(s)) {error = "Поле \"Баланс\" должно содержать только цифры!";return -1;
                        }
                        if (s.equals("0")) {new_data_acc[i] = "0.00*";return 0;}
                        if (s.contains(".")) {String[] balance = s.split("\\.");//делим на дробную и целую части
                            if (balance[1].length() > 2) {//проверка дробной части
                                error = "Поле \"Баланс\" превышает максимальное значение!";
                                return -1;
                            }
                        } else {
                            if (s.length() > 6) {error = "Поле \"Баланс\" превышает максимальное значение!";return -1;}
                        }
                        break;
                    case 3://дата договора
                        if (s.equals("null")) {error = "Поле \"Дата договора\" не может быть пустым!";return -1;
                        } else {
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date date = format.parse(s);
                            java.util.Date cur_date = new java.util.Date();
                            if (date.after(cur_date)) {
                                error = "Поле \"Дата договора\" не может быть больше текущей даты!";
                                return -1;
                            }
                        }
                        break;
                    case 4://номер договора
                        if (s.equals("")) {error = "Поле \"Номер договора\" не может быть пустым!";return -1;}
                        if ((!Methods.isOnlyDigit(s) && !s.equals(""))) {error = "Поле \"Номер договора\" должно содержать только цифры!";return -1;}
                        if (s.length() > 6) {error = "Поле \"Номер договора\" содержит много символов!";return -1;}
                        break;
                    case 6://владелец
                        if (s.equals("")) {error = "Поле \"Владелец\" не может быть пустым!";return -1;}
                        if (!Methods.isLetter(s)) {error = "Поле \"Владелец\" должно содержать только буквы!";return -1;}
                        if (s.length() > 100) {error = "Поле \"Владелец\" содержит много символов!";return -1;}
                        break;
                    case 8://телефон
                        if (s.equals("")) {error = "Поле \"Телефон\" не может быть пустым!";return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"Телефон\" должно содержать только цифры!";return -1;}
                        if (s.length() > 11) {error = "Поле \"Телефон\" содержит много символов!";return -1;}
                        break;
                }
            }
        return 0;
    }

    /*
    * Проверяет поля адреса на корректность
    * Принимает массив с адресом
    * Возвращает 0 - нет ошибок
    * -1 - ошибка
    */
    private static int checkAdresFields(String[] new_adres) {
        String s;
        for (int i = 1; i < new_adres.length; i++)
            if (new_adres[i].contains("*")) {//если поле было изменено
                s = new_adres[i].replaceAll("\\*", "");//убираем звездочку
                switch (i) {//район проверять не нужно
                    case 1://проверка улицы
                        if (s.equals("")) {error = "Поле \"Улица\" не может быть пустым!";return -1;}
                        if (s.length() > 50) {error = "Поле \"Улица\" содержит много символов!";return -1;}
                        if (!Methods.isStreet(s)) {error = "Поле \"Улица\" содержит недопустимые символы или имеет неправильный формат!";return -1;}
                        break;
                    case 2: //дом
                        if (!Methods.isLetterOrDigit(s)) {error = "Поле \"Дом\" должно содержать  цифры или буквы!";return -1;}
                        if (s.equals("")) {error = "Поле \"Дом\" не может быть пустым!";return -1;}
                        if (s.length() > 4) {error = "Поле \"Дом\" содержит много символов!";return -1;}
                        break;
                    case 3://квартира
                        if (s.length() > 3) {error = "Поле \"Квартира\" содержит много символов!";return -1;}
                        if ((!Methods.isOnlyDigit(s) && !s.equals(""))) {error = "Поле \"Квартира\" должно содержать только цифры!";return -1;}
                        break;
                    case 4://корпус
                        if (!Methods.isLetterOrDigit(s)) {error = "Поле \"Корпус\" должно содержать  цифры или буквы!";return -1;}
                        if (s.length() > 3) {error = "Поле \"Корпус\" содержит много символов!";return -1;}
                        break;
                    case 5://индекс
                        if (s.equals("")) {error = "Поле \"Индекс\" не может быть пустым!";return -1;}
                        if (s.length() != 6) {error = "Поле \"Индекс\" должно содержать 6 символов!";return -1;}
                        if (!Methods.isOnlyDigit(s) || s.contains("-")) {error = "Поле \"Индекс\" должно содержать только цифры!";return -1;}
                        break;
                }
            }
        return 0;
    }

    /*
    * Метод изменяет данные для юр. лица
    * Принимает новые данные
    * */
    private static void changeDataAccCompany(String[] new_data_comp) throws Exception {
        String column[] = Methods.getColumnName("account_company").split(" ");//названия колонок таблицы account_company
        String query = "update account_company set ";
        for (int i = 1; i < new_data_comp.length; i++) {//с 1 - так как номер лицевого счета не изменяется
            if (new_data_comp[i].contains("*"))//поле содержит звездочку
                if (i == 1) {//банк
                    int id_bank = getIndex(new_data_comp[i].replaceAll("\\*", ""), 3);//получаем индекс банка, передаем название банка
                    if (id_bank == -1) {
                        addNewData(new_data_comp[i].replaceAll("\\*", ""), 2);//если нет,то добавить в базу
                        id_bank = getIndex(new_data_comp[i].replaceAll("\\*", ""), 3);//получаем индекс нового банка
                    }
                    query += "bank = " + id_bank + ",";//если такая улица уже есть в базе
                } else query += column[i] + " = \"" + new_data_comp[i].replaceAll("\\*", "") + "\",";
        }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query += " where num_account = " + new_data_comp[0];
        //выполняем запрос
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод изменяет данные для физ. лица
    * Принимает новые данные
    * */
    private static void changeDataAcc(String[] new_data_acc) throws SQLException {
        String column[] = Methods.getColumnName("account").split(" ");//названия колонок таблицы account
        String query = "update account set ";
        for (int i = 1; i < new_data_acc.length; i++) {//с 1 - так как номер лицевого счета не изменяется
            if (new_data_acc[i].contains("*"))//поле содержит звездочку
                query += column[i] + " = \"" + new_data_acc[i].replaceAll("\\*", "") + "\",";
        }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query += " where num_account = " + new_data_acc[0];
        //выполняем запрос
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод изменяет адрес
    * Принимает номер аккаунта и айди нового адреса
    * */
    private static void changeAdres(String num_acc, String id_adrs) throws Exception {
        String query="update account set adres = "+id_adrs+" where num_account = "+num_acc;
        //выполняем запрос
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод добавляет в базу данных новую улицу,индекс,банк
    * int what: 0- улица,1 - индекс,2 - банк
    * */
    private static void addNewData(String data, int what) throws SQLException {
        String query;
        if (what == 0) query = "insert into cat_street (street) values (" + "\"" + data + "\")";//добавляем улицу
        else if (what == 1) query = "insert into cat_index (indx) values (" + data + ")";//добавляем индекс
        else query = "insert into cat_bank (bank) values (" + "\"" + data + "\")";//добавляем банк
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.close();
    }

    /*
    * Метод получает последний номер аккаунта в таблице account
    * */
    public static int getLastNumAccount() throws SQLException {
        String query = "select MAX(num_account) AS result from account ";
        int num_account = -1;
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                num_account = resSet.getInt("result");
            }
            return num_account;
        }
        statement.close();
        return -1;
    }

    /*
    * Метод добавляет в бд новый лицевой счет
    * Принимает данные и account: true - физ.лицо, false - юр.лицо
    * Возвращает 0  - нет ошибок, -1 -ошибка
    * */
    public static int addAccount(String[] data, boolean account) throws Exception {
        String adres[] = new String[6];
        adres[0] = data[15];//район
        if(adres[0].equals("НЕ ВЫБРАНО")) {
            error="Выберите район!";
            return  -1;
        }
        adres[1] = data[6];//улица
        adres[2] = data[7];//дом
        adres[3] = data[9];//квартира
        adres[4] = data[8];//корпус
        adres[5] = data[10];//индекс*/

        //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
        for (int i=0;i<adres.length;i++)adres[i]+="*";

        if(checkAdresFields(adres)!=0)return -1;//проверка на корректность адреса

        String account_data[]=new String[10];
        account_data[0] = data[0];//номер лицевого счета
        account_data[1] = data[1] + " " + data[2] + " " + data[3];//ФИО
        account_data[2] = data[4];//баланс
        account_data[3] = data[16];//дата договора
        account_data[4] = data[5];//номер договора
        account_data[5] = null;//адрес (пока еще не добавился в бд)
        account_data[6] = data[12];//владелец
        account_data[7] = data[14];//тип потребителя
        account_data[8] = data[11];//телефон
        account_data[9] = data[13];//статус аккаунта

        //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
        for (int i=0;i<account_data.length;i++)account_data[i]+="*";
        if(checkAccountFields(account_data)!=0)return -1;//проверка на корректность полей

        String account_data_company[] =new String[7];
        if(!account) {//если добавляется юр.лицо
            account_data_company[0] = data[0];//номер лицевого счета
            //получаем индекс банка
            int id_bank=getIndex(data[17],3);
            if(id_bank==-1) {
                addNewData(data[17], 2);//добавляем новый банк
                id_bank=getIndex(data[17], 3);//получаем индекс
            }
            account_data_company[1] = String.valueOf(id_bank);
            account_data_company[2] = data[18];//кпп
            account_data_company[3] = data[19];//счет
            account_data_company[4] = data[20];//номер свид
            account_data_company[5] = data[21];//инн
            account_data_company[6] = data[22];//название компании
            //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
            for (int i=0;i< account_data_company.length;i++) account_data_company[i]+="*";
            if(checkAccountCompFields(account_data_company)!=0)return -1;//проверка на корректность полей
            for (int i=0;i< account_data_company.length;i++) account_data_company[i]= account_data_company[i].replaceAll("\\*","");//удаление звездочек (поля для юр.лица)
        }

        for (int i=0;i<adres.length;i++)adres[i]=adres[i].replaceAll("\\*","");//удаление звездочек (адрес)
        for (int i=0;i<account_data.length;i++)account_data[i]=account_data[i].replaceAll("\\*","");//удаление звездочек (поля для физ.лица)

        int chec_adres=getIdFromAdres(adres);
        if(chec_adres!=-1)account_data[5]= String.valueOf(chec_adres);//если такой адрес уже есть в системе
        else account_data[5] = Integer.toString(addNewAdres(adres));//добавление адреса

        receiveQueryNewAccount(account_data,true);//физ.лицо
        if(!account)receiveQueryNewAccount( account_data_company,false);//если юр.лицо
        return 0;
    }
    /*
    * Метод составляет запрос на добавление нового лицевого счета и выполняет его
    * account = true - физ.лицо,false-юр.лицо
    */
    private static void receiveQueryNewAccount(String[] data,boolean account) throws SQLException {
        String column [];
        String query;
        if(account) {//если физ.лицо
             column= Methods.getColumnName("account").split(" ");
             query="insert into account (";
        }
        else{//юр.лицо
            column = Methods.getColumnName("account_company").split(" ");
            query ="insert into account_company (";
        }

        for (String aColumn : column) query += aColumn + ",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query+=") values (";
        for (String aData : data) query += "\"" + aData + "\",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query+=")";
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.close();
    }
    /*
    * Метод добавляет новый адрес в таблицу adres
    * */
    private static int addNewAdres(String[] adres) throws Exception {
        String query = "insert into adres(id_district,id_street,house,flat,corpus,id_index) values (";
        for (int i = 0; i < adres.length; i++)
            switch (i){
                case 0://район
                    int id_district = getIndex(adres[i], 0);//получаем индекс района, передаем название района
                    query += "\"" + id_district + "\",";
                    break;
                case 1://улица
                    int id_street = getIndex(adres[i], 1);//получаем индекс улицы, передаем название улицы
                    if (id_street == -1) {
                        addNewData(adres[i], 0);//если нет,то добавить в базу
                        id_street = getIndex(adres[i], 1);//получаем индекс новой улицы
                    }
                    query += "\"" + id_street + "\",";//если такая улица уже есть в базе
                    break;
                case 2://дом
                    query += "\"" + adres[i] + "\",";
                    break;
                case 3://квартира
                    query += "\"" + adres[i] + "\",";
                    break;
                case 4://корпус
                    query += "\"" + adres[i] + "\",";
                    break;
                case 5://индекс
                    int id_index = getIndex(adres[i], 2);//получаем индекс индекса, передаем название индекса
                    if (id_index == -1) {
                        addNewData(adres[i], 1);//если нет,то добавить в базу
                        id_index = getIndex(adres[i], 2);//получаем индекс нового индекса
                    }
                    query += "\"" + id_index+"\"";
                    break;
            }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        //закрываем скобку
        query+=")";
        //выполняем запрос
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query="select MAX(id_adres) AS id from adres";
        int id_adres=-1;//айди добавленного адреса
        ResultSet resSet = null;
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                id_adres = resSet.getInt("id");
            }
        }
        statement.close();
        return id_adres;
    }

    /*
    * Выполнение запроса к таблице Account
    * String q - запрос
    * boolean inTable - заполняется таблица из формы,иначе - из таблицы в форму
    * boolean type -  true - физ.лицо,false - юр.лицо
    * */
    private static int receivingQueryForSearch(String q, boolean inTable, boolean type) throws Exception {
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                if (type) {
                    Account.num_account = resSet.getInt("num_account");
                    Account.FIO = resSet.getString("FIO");
                    Account.balance = resSet.getDouble("balance");
                    Account.date_contract = resSet.getDate("date_contract");
                    Account.num_contract = resSet.getInt("num_contract");
                    Account.adres = resSet.getInt("adres");
                    Account.owner_flat = resSet.getString("owner_flat");
                    Account.cons_type = resSet.getString("cons_type");
                    Account.telephone = resSet.getString("telephone");
                    Account.acc_status = resSet.getString("acc_status");
                }
                else{
                    Account.num_account = resSet.getInt("num_account");
                    Account.FIO = resSet.getString("FIO");
                    Account.balance = resSet.getDouble("balance");
                    Account.date_contract = resSet.getDate("date_contract");
                    Account.num_contract = resSet.getInt("num_contract");
                    Account.adres = resSet.getInt("adres");
                    Account.owner_flat = resSet.getString("owner_flat");
                    Account.cons_type = resSet.getString("cons_type");
                    Account.telephone = resSet.getString("telephone");
                    Account.acc_status = resSet.getString("acc_status");
                    Account.bank =  resSet.getInt("bank");
                    Account.kpp = resSet.getInt("kpp");
                    Account.pay_account = resSet.getLong("pay_account");
                    Account.num_cert = resSet.getLong("num_cert");
                    Account.INN = resSet.getLong("INN");
                    Account.name_company = resSet.getString("name_company");
                }
                if (inTable)
                    GAccount.AddRowTable();//запись в таблицу
                else {
                    getNamesFromIndexes(adres, bank, type);//получить названия по индексам
                }
            }
            statement.close();
            return 0;//что-то найдено
        }
        statement.close();
        return -1;//не найдено
    }

    /*
    * Метод получает названия по индексам
    * int adres - ид адреса
    * int bank - ид банка
    * type - физ.лицо(true) или юр.лицо(false)
    * Заполняет глобальный массив данными
    * */
    private static void getNamesFromIndexes(int id_adres, int id_bank, boolean type) throws SQLException {
        //расшифровываем адрес
        String[] adres = getAdresFromId(id_adres);
        String bank = "";
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        if (!type) {//для юр.лица нужно расшифровать банк
            String query_bank = "select bank from cat_bank where id=" + id_bank;
            try {
                statement = Connect.connection.createStatement();
                resSet = statement.executeQuery(query_bank);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (resSet != null && resSet.isBeforeFirst()) {
                while (resSet.next()) {
                    bank = resSet.getString("bank");
                }
            }
            statement.close();
            names_indexes = new String[7];
            System.arraycopy(adres, 0, names_indexes, 0, 6);//копирование полей адреса
            names_indexes[6] = bank;//копирование банка

        } else {
            names_indexes = new String[6];
            System.arraycopy(adres, 0, names_indexes, 0, 6);//копирование полей адреса
        }
    }

    /*
    * Получает адрес по ид адрес
    * Расшифровывает названия по индексам
    * Возвращает адрес в нормальном виде
    * */
    private static String[] getAdresFromId(int id_adres) throws SQLException {
        String query = "select * from adres where id_adres=" + id_adres;
        String adres_ind[] = new String[6];//0-район,1-улица,2-дом,3-квартира,4-корпус,5-индекс
        //получение "цифрового" адреса
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                adres_ind[0] = Integer.toString(resSet.getInt("id_district"));
                adres_ind[1] = Integer.toString(resSet.getInt("id_street"));
                adres_ind[2] = resSet.getString("house");
                adres_ind[3] = resSet.getString("flat");
                adres_ind[4] = resSet.getString("corpus");
                adres_ind[5] = Integer.toString(resSet.getInt("id_index"));
            }
        }
        //запросы на расшифровку индексов
        String queries[] = new String[3];
        queries[0] = "select district from cat_district where id=" + Integer.parseInt(adres_ind[0]);
        queries[1] = "select street from cat_street where id=" + Integer.parseInt(adres_ind[1]);
        queries[2] = "select indx from cat_index where id=" + Integer.parseInt(adres_ind[5]);
        //названия колонок
        String columns[] = new String[3];
        columns[0] = "district";
        columns[1] = "street";
        columns[2] = "indx";
        //название по индексам
        String new_adres[] = new String[3];//0-район,1-улица,2- индекс
        for (int i = 0; i < queries.length; i++) {
            resSet = null;
            try {
                resSet = statement.executeQuery(queries[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (resSet != null && resSet.isBeforeFirst()) {
                while (resSet.next()) {
                    new_adres[i] = resSet.getString(columns[i]);
                }
            }
        }
        statement.close();
        String adres[] = new String[6];
        adres[0] = new_adres[0];//район
        adres[1] = new_adres[1];//улица
        adres[2] = adres_ind[2];//дом
        adres[3] = adres_ind[3];//квартира
        adres[4] = adres_ind[4];//корпус
        adres[5] = new_adres[2];//индекс
        return adres;
    }

    /*
    * Получает ИД адреса по данным адреса
    * Принимает адрес
    * Возвращает его айди
    * */
    private static int getIdFromAdres(String [] adres) throws Exception {
        int id_adres=-1;
        String query ="select id_adres from adres where ";
        String column[]=Methods.getColumnName("adres").split(" ");
        for(int i=0,j=1;i<adres.length;i++,j++){
            switch (i){
                case 0://район
                    int id_district = getIndex(adres[i],0);
                    query+=column[j]+" = \""+id_district +"\""+ " and ";
                    break;
                case 1://улица
                    int id_street = getIndex(adres[i],1);
                    query+=column[j]+" = \""+id_street+"\""+ " and ";
                    break;
                case 2://дом
                case 3://квартира
                case 4: //корпус
                    query+=column[j]+" = \""+adres[i]+"\""+ " and ";
                    break;
                case 5://индекс
                    int id_index=getIndex(adres[i],2);
                    query+=column[j]+" = \""+id_index+"\""+ " and ";
                    break;
            }
        }
        if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                id_adres = resSet.getInt("id_adres");
            }
            statement.close();
            return  id_adres;
        }
        statement.close();
        return id_adres;
    }
}