package WORK;
import GUI.GAccount;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static WORK.Methods.getColumnName;

/*
 * Created by Юлия on 02.05.2017.
 */
public class Account{
    public static String names_indexes[];
    public static Account account;
    public static Statement statement;

    public int num_account;
    //физ.лицо
    public String FIO;
    public double balance;
    public Date date_contract;
    public int num_contract;
    public int adres;
    public String owner_flat;
    public String cons_type;
    public String telephone;
    public String acc_status;
    //юр.лицо
    public int bank;
    public int kpp;
    public int bik;
    public long pay_account;
    public long num_cert;
    public long INN;
    public String name_company;

    public Account() {
    }
    //для юр.лиц
    public Account(int num_account,
                   String FIO,
                   double balance,
                   Date date_contract,
                   int num_contract,
                   int adres,
                   String owner_flat,
                   String cons_type,
                   String telephone,
                   String acc_status,
                   int bank,
                   int kpp,
                   int bik,
                   long pay_account,
                   long num_cert,
                   long INN,
                   String name_company
    ) {
        this.num_account = num_account;
        this.FIO =FIO;
        this.balance = balance;
        this.date_contract = date_contract;
        this.num_contract = num_contract;
        this.adres=adres;
        this.owner_flat = owner_flat;
        this.cons_type = cons_type;
        this.telephone = telephone;
        this.acc_status = acc_status;
        this.bank = bank;
        this.kpp = kpp;
        this.bik = bik;
        this.pay_account = pay_account;
        this.num_cert = num_cert;
        this.INN = INN;
        this.name_company = name_company;
    }
    //для физ.лиц
    public Account(int num_account,
                   String FIO,
                   double balance,
                   Date date_contract,
                   int num_contract,
                   int adres,
                   String owner_flat,
                   String cons_type,
                   String telephone,
                   String acc_status
    ) {
        this.num_account = num_account;
        this.FIO = FIO;
        this.balance = balance;
        this.date_contract = date_contract;
        this.num_contract = num_contract;
        this.adres = adres;
        this.owner_flat = owner_flat;
        this.cons_type = cons_type;
        this.telephone = telephone;
        this.acc_status = acc_status;
    }

    /*
   Метод формирует запрос для отображения данных лицевого счета в форму,
   по номеру лицевого счета (полученного из таблицы)
   Принимает номер лицевого счета и тип абонента
   */
    public static void showAccount(String num_acc, String cons_type) throws Exception {
        String query;
        if (cons_type.equals("ФИЗИЧЕСКОЕ ЛИЦО")) {//для физ.лица
            query = "select * from account where num_account=" + num_acc;
            account = new Account();
            account.receivingQuery(query, false, true);
        } else {//для юр.лица
            query = "select * from account JOIN account_company ON account.num_account=account_company.num_account and account.num_account=" + num_acc;
            account = new Account();
            account.receivingQuery(query, false, false);
        }
    }

    /*
    Метод формирует запрос для поиска лицевого счета по данным,полученным из формы
    Принимает массив с данными
    */
    public static int searchAccount(String data[]) throws Exception {
        account=null;
        //сначала нужно проверить,заполнено хотя бы одно поле из адреса (улица,дом,кв,корпус,индекс)
        //если заполнено,нужно выполнить запрос поиска по таблице adress и получить подходящие id_adress
        //затем искать в таблице account по введенным полям и id_adress
        //затем нужно проверить,заполнено ли хотя бы одно поле для юр.лиц
        //если заполнено, то составить запрос на объединение двух таблиц через JOIN
        String column_account[] = getColumnName("watermeter.account").split(" ");//получение имен колонок таблицы account
        //подсчет пустых полей
        int counter = 0;
        for (String d : data) if (!(d == null)) counter++;// нахождение количества ненулевых критериев запроса
        if (counter == 0) return -1;//если введена пустая строка
        //обработка адреса
        String address[] = new String[6];
        System.arraycopy(data, 10, address, 0, 6);//копирование полей адреса
        data[5] = checkAddress(address);//проверка,заполнено ли хотя бы одно поле адреса и формирование индексов подходящих адресов
        if (data[5].equals("not found")) return -1;//ничего не найдено,дальше нет смысла проверять
        //если поля для юр.лиц не заполнены
        if (data[16] == null && data[17] == null && data[18] == null && data[19] == null && data[20] == null && data[21] == null && data[22] == null) {
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
            account = new Account();
            return account.receivingQuery(query, true, true); //0-найдено,-1-не найдено
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
            //j-пробег по данным с 16 по 22 ячейку (поля для юр.лиц)
            //формирование запроса для юр.лиц
            for (i = 1, j = 16; i < column_account_comp.length && j < data.length; i++, j++)
                if (j != 22)//22- название компании,добавиться в конце
                    if (data[j] != null)
                        query += "account_company." + column_account_comp[i] + "='" + data[j] + "'" + " and ";
            if (data[22] != null) query += "account_company.name_company like '%" + data[22] + "%'";
            if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());

            account = new Account();
            return account.receivingQuery(query, true, false);
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
    public static void DeleteAccount(String num_acc) throws SQLException {
        String query="delete from account where num_account="+num_acc;
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
    *
    * */
    public static int changeData(String[] new_data) throws Exception {
        int id_adres=-1;
        boolean changed_adres=false;//флаг изменения адреса (true - адрес был изменен)
        boolean changed_fieldsAcc=false;//флаг изменения полей для физ.лица (true - хотя бы одно поле было изменено)
        boolean changed_fieldsComp=false;//флаг изменения полей для юр.лица (true - хотя бы одно поле было изменено)

        //проверка адреса
        String  new_adres[]=new String[6];
        new_adres[0]=new_data[20];//район
        new_adres[1]=new_data[6];//улица
        new_adres[2]=new_data[7];//дом
        new_adres[3]=new_data[9];//квартира
        new_adres[4]=new_data[8];//корпус
        new_adres[5]=new_data[10];//индекс

        for(int i=0;i<new_adres.length;i++)
            if(new_adres[i].contains("*")){
                changed_adres=true;break;
            }
        if(changed_adres){//если хотя бы одно поле адреса было изменено
        //тут должны проверяться поля адреса на содержимое
            id_adres=changeAdres(new_data[0],new_adres);//new_data[0]- номер аккаунта,который не изменяется
         }


        //работа с полями для физ.лица,сборка данных в массив,удобный для использования
        String new_data_acc [] = new String[10];//данные из полей для физ.лица
        new_data_acc[0]=new_data[0];//номер лицевого счета
        new_data_acc[1]=new_data[1]+" "+new_data[2]+" "+new_data[3];//ФИО
        new_data_acc[2]=new_data[4];//баланс
        new_data_acc[3]=new_data[23];//дата договора
        new_data_acc[4]=new_data[5];//номер договора
        new_data_acc[5]=Integer.toString(id_adres);//адрес (к этому моменту он уже поменялся)
        new_data_acc[6]=new_data[12];//владелец
        new_data_acc[7]=new_data[21];//тип потребителя
        new_data_acc[8]=new_data[11];//телефон
        new_data_acc[9]=new_data[22];//статус аккаунта

        for(int i=0;i<new_data_acc.length;i++)
            if(new_data_acc[i].contains("*")){
                changed_fieldsAcc=true;break;
            }
        if(changed_fieldsAcc){//если хотя бы одно поле  было изменено
           //тут должна быть проверка на содержимое полей
            changeDataAcc(new_data_acc);//изменение полей для физ.лица
        }


        if(new_data_acc[7].equals("ЮРИДИЧЕСКОЕ ЛИЦО")){
            String new_data_comp []= new String[8];//данные из полей для юр.лица
            new_data_comp[0]=new_data[0];//номер лицевого счета
            new_data_comp[1]=new_data[15];//банк
            new_data_comp[2]=new_data[18];//кпп
            new_data_comp[3]=new_data[19];//бик
            new_data_comp[4]=new_data[16];//расчетный счет
            new_data_comp[5]=new_data[14];//номер сертификата
            new_data_comp[6]=new_data[17];//инн
            new_data_comp[7]=new_data[13];//название компании

            for(int i=0;i< new_data_comp.length;i++)
                if(new_data_comp[i].contains("*")){
                    changed_fieldsComp=true;break;
                }

            if(changed_fieldsComp){//если хотя бы одно поле  было изменено
                //тут должна быть проверка на содержимое полей
                changeDataAccCompany(new_data_comp);//изменение полей для юр.лица
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
        String query="update account_company set ";
        for(int i =1;i<new_data_comp.length;i++){//с 1 - так как номер лицевого счета не изменяется
            if(new_data_comp[i].contains("*"))//поле содержит звездочку
                if(i==1){//банк
                    int id_bank = getIndex(new_data_comp[i].replaceAll("\\*", ""), 3);//получаем индекс банка, передаем название банка
                    if(id_bank==-1){
                        addNewData(new_data_comp[i].replaceAll("\\*", ""),2);//если нет,то добавить в базу
                        id_bank=getIndex(new_data_comp[i].replaceAll("\\*", ""),3);//получаем индекс нового банка
                    }
                    query+="bank = "+id_bank+",";//если такая улица уже есть в базе
                }
                else query+=column[i]+" = \""+new_data_comp[i].replaceAll("\\*", "")+"\",";
        }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query+=" where num_account = "+new_data_comp[0];
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
        String query="update account set ";
        for(int i =1;i<new_data_acc.length;i++){//с 1 - так как номер лицевого счета не изменяется
            if(new_data_acc[i].contains("*"))//поле содержит звездочку
                query+=column[i]+" = \""+new_data_acc[i].replaceAll("\\*", "")+"\",";
        }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query+=" where num_account = "+new_data_acc[0];
        System.out.println(query);
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
    * Принимает номер аккаунта и новый адрес
    * */
    private static int changeAdres(String num_acc, String[] new_adres) throws Exception {
        String query = "select adres from account where num_account = "+num_acc;//ищем айди старого адреса
        int id_adres=-1;//ид старого адреса

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
               id_adres=resSet.getInt("adres");
            }
        }
        statement.close();

        query="update adres set ";
        for(int i=0;i<new_adres.length;i++){
            if(new_adres[i].contains("*"))//если поле содержит звездочку
                switch (i){
                    case 0://район
                        int id_district = getIndex(new_adres[i].replaceAll("\\*", ""), 0);//получаем индекс района, передаем название района
                        query+="id_district = "+id_district+",";
                        break;
                    case 1://улица
                        int id_street = getIndex(new_adres[i].replaceAll("\\*", ""), 1);//получаем индекс улицы, передаем название улицы
                        if(id_street==-1){
                            addNewData(new_adres[i].replaceAll("\\*", ""),0);//если нет,то добавить в базу
                            id_street=getIndex(new_adres[i].replaceAll("\\*", ""),1);//получаем индекс новой улицы
                        }
                        query+="id_street = "+id_street+",";//если такая улица уже есть в базе
                        break;
                    case 2://дом
                        query+="house = "+new_adres[i].replaceAll("\\*", "")+",";
                        break;
                    case 3://квартира
                        query+="flat = \""+new_adres[i].replaceAll("\\*", "")+"\" ,";
                        break;
                    case 4://корпус
                        query+="corpus =\""+new_adres[i].replaceAll("\\*", "")+"\" ,";
                        break;
                    case 5://индекс
                        int id_index = getIndex(new_adres[i].replaceAll("\\*", ""), 2);//получаем индекс индекса, передаем название индекса
                        if(id_index==-1){
                            addNewData(new_adres[i].replaceAll("\\*", ""), 1);//если нет,то добавить в базу
                            id_index=getIndex(new_adres[i].replaceAll("\\*", ""),2);//получаем индекс нового индекса
                        }
                        query+="id_index = "+id_index;
                        break;
            }
        }
        //обрезаем последнюю запятую
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query+=" where id_adres = "+id_adres;
        //выполняем запрос
        statement = Connect.connection.createStatement();
            try {
                statement = Connect.connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id_adres;
    }

    /*
    * Метод добавляет в базу данных новую улицу,индекс,банк
    * int what: 0- улица,1 - индекс,2 - банк
    * */
    private static void addNewData(String data,int what) throws SQLException {
        String query;
        if(what==0)  query= "insert into cat_street (street) values ("+"\""+data+"\")";//добавляем улицу
        else if(what==1) query= "insert into cat_index (indx) values ("+data+")";//добавляем индекс
        else query= "insert into cat_bank (bank) values ("+"\""+data+"\")";//добавляем банк
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
    * Выполнение запроса к таблице Account
    * String q - запрос
    * boolean inTable - заполняется таблица из формы,иначе - из таблицы в форму
    * boolean type -  true - физ.лицо,false - юр.лицо
    * */
    private int receivingQuery(String q, boolean inTable, boolean type) throws Exception {
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                if (type)
                    account = new Account(
                            resSet.getInt("num_account"),
                            resSet.getString("FIO"),
                            resSet.getDouble("balance"),
                            resSet.getDate("date_contract"),
                            resSet.getInt("num_contract"),
                            resSet.getInt("adres"),
                            resSet.getString("owner_flat"),
                            resSet.getString("cons_type"),
                            resSet.getString("telephone"),
                            resSet.getString("acc_status")
                    );
                else
                    account = new Account(
                            resSet.getInt("num_account"),
                            resSet.getString("FIO"),
                            resSet.getDouble("balance"),
                            resSet.getDate("date_contract"),
                            resSet.getInt("num_contract"),
                            resSet.getInt("adres"),
                            resSet.getString("owner_flat"),
                            resSet.getString("cons_type"),
                            resSet.getString("telephone"),
                            resSet.getString("acc_status"),
                            resSet.getInt("bank"),
                            resSet.getInt("kpp"),
                            resSet.getInt("bik"),
                            resSet.getLong("pay_account"),
                            resSet.getLong("num_cert"),
                            resSet.getLong("INN"),
                            resSet.getString("name_company")
                    );
                if (inTable)

                    GAccount.AddRowTable(account);//запись в таблицу
                else {
                    getNamesFromIndexes(account.adres, account.bank, type);//получить названия по индексам
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
    private void  getNamesFromIndexes(int id_adres, int id_bank, boolean type) throws SQLException {
        //расшифровываем адрес
        String query_adr = "select * from adres where id_adres=" + id_adres;
        String[] adres = receivinQueryAdres(query_adr);
        String bank="";
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
                    bank=resSet.getString("bank");
                }
            }
            statement.close();
            names_indexes=new String[7];
            System.arraycopy(adres, 0, names_indexes, 0, 6);//копирование полей адреса
            names_indexes[6]=bank;//копирование банка

        }
        else {
            names_indexes = new String[6];
            System.arraycopy(adres, 0, names_indexes, 0, 6);//копирование полей адреса
        }
    }

    /*
    * Получает адрес по ид адрес
    * Расшифровывает названия по индексам
    * Возвращает адрес в нормальном виде
    * */
    private String[] receivinQueryAdres(String query) throws SQLException {
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
                adres_ind[3] = Integer.toString(resSet.getInt("flat"));
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
}