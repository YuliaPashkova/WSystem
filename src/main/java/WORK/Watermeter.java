package WORK;
import GUI.GWatermeter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Created by Юлия on 10.05.2017.
 */
public class Watermeter {
    public static String error;//текст ошибки
    public static int num_acc;
    public static int code_watcon;
    public static String type;
    public static int inv_num;
    public static int serial_num;
    public static int year_release;
    public static Date date_check;
    public static int caliber;
    public static String installed;
    public static Date date_set;
    public static int prim_indications;
    public static Date enter_exploit;
    public static Date seal;//опломбирован
    public static int last_indications;
    public static Date check_last_indic;
    public static String status;
    public static Watermeter watermeter;
    private static Statement statement;

    /*
     Метод формирует запрос для поиска водомера по коду ВП (если открыть из формы ВП)
     Принимает код ВП
     */
    public static int searchWatermeter(String code) throws SQLException {
        String query = "select * from watermeter where code_watcon = \"" + code + "\"";
        return receivingQueryForSearch(query, true);
    }
    /*
     Метод формирует запрос для поиска водомера по номеру лицевого счета (карточка водомера)
     Принимает номер счета
     */
    public static int searchWatermeterForCard(String num_acc) throws SQLException {

        String query = "select * from watermeter where code_watcon IN(SELECT code FROM waterconnection where num_account= "+num_acc+" )";
        return receivingQueryForSearch(query, true);
    }
    /*
   * Выполнение запроса к таблице watermeter
   * String query - запрос
   * boolean inTable - заполняется таблица из формы,иначе - из таблицы в форму
   * */
    private static int receivingQueryForSearch(String query, boolean inTable) throws SQLException {
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                code_watcon = resSet.getInt("code_watcon");
                type = resSet.getString("type");
                inv_num =resSet.getInt("inv_num");
                serial_num =resSet.getInt("serial_num");
                year_release = resSet.getInt("year_release");
                date_check = resSet.getDate("date_check");
                caliber = resSet.getInt("caliber");
                installed = resSet.getString("installed");
                date_set =resSet.getDate("date_set");
                prim_indications =resSet.getInt("prim_indications");
                enter_exploit = resSet.getDate("enter_exploit");
                seal = resSet.getDate("seal");
                last_indications = resSet.getInt("last_indications");
                check_last_indic =resSet.getDate("check_last_indic");
                status =  resSet.getString("status");
                if (inTable) {
                    num_acc=getNumAccountFromCode();
                    GWatermeter.AddRowTable();//запись в таблицу
                }
            }
            statement.close();
            return 0;//что-то найдено
        }
        statement.close();
        return -1;//не найдено

    }
    /*
    * Получает номер аккаунта по коду подключения
    * */
    private static int getNumAccountFromCode() throws SQLException {
        String query = "select num_account from waterconnection where code = "+code_watcon;
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
                num_account = resSet.getInt("num_account");
            }
            return num_account;
        }
        statement.close();
        return -1;
    }
    /*
     Метод формирует запрос для отображения данных водомера в форму,
     по заводскому номеру водомера (полученного из таблицы)
     Принимает заводской номер
     */
    public static void showWatermeter(String serial_num) throws SQLException {
        String query = "select * from watermeter where serial_num = " +serial_num;
        receivingQueryForSearch(query, false);
    }
    /*
     * Метод удаляет водомер с serial_num
     */
    public static void deleteWatermeter(String serial_num) {
        String query = "delete from watermeter where serial_num = " + serial_num;
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
     * -1 - ошибка
     * Принимает new_data - новые данные,old_serial_num - серийный номер до изменения
     * */
    public static int changeWatermeter(String[] new_data,String old_serial_num) throws SQLException, ParseException {
        String data[] = new String[15];
        data[0]=new_data[0];//код ВП
        data[1]=new_data[1];//тип
        data[2]=new_data[2];//инвентарный номер
        data[3]=new_data[3];//серийный номер
        data[4]=new_data[4];//год выпуска
        data[5]=new_data[13];//дата поверки
        data[6]=new_data[5];//калибр
        data[7]=new_data[9];//установлен
        data[8]=new_data[10];//дата установки
        data[9]=new_data[6];//начальные показания
        data[10]=new_data[11];//ввод в экспл.
        data[11]=new_data[12];//опломбирован
        data[12]=new_data[7];//последние показания
        data[13]=new_data[14];//дата снятия последних показаний
        data[14]=new_data[8];//статус

        int result = checkWatermeterFields(data);//проверка полей  на содержимое
        if (result == 0) receivingQueryForChanging(data,old_serial_num);//изменение полей
        else return result;
        return 0;


    }
    /*
     * Метод изменяет данные ВП
     * Принимает новые данные
     */
    private static void receivingQueryForChanging(String[] data,String old_serial_num) throws SQLException {
        String[] column = Methods.getColumnName("watermeter").split(" ");
        String query = "update watermeter set ";
        for (int i = 1; i < data.length; i++)//с 1 - так как код ВП не изменяется
            if (data[i].contains("*"))  //поле содержит звездочку
                query += column[i] + " = \"" + data[i].replaceAll("\\*", "") + "\",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query += " where serial_num = " + old_serial_num;
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
     * Метод проверяет содержимое полей на корректность
     * Возващает 0 - если нет ошибок
     * -1 - если ошибка
     */
    private static int checkWatermeterFields(String[] data) throws ParseException, SQLException {
        String s;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date cur_date = new java.util.Date();
        java.util.Date date;
        String name_column[]=new String[15];
        name_column[1]="Тип";
        name_column[2]="Инвентарный номер";
        name_column[3]="Заводской номер";
        name_column[4]="Год выпуска";
        name_column[5]="Поверка";
        name_column[6]="Калибр";
        name_column[7]="Установлен";
        name_column[8]="Дата установки";
        name_column[9]="Начальные показания";
        name_column[10]="Ввод в экспл.";
        name_column[11]="Опломбирован";
        name_column[11]="Последние показания";
        name_column[13]="Дата снятия последних показаний";
        name_column[14]="Статус";
        for (int i = 1; i < data.length; i++)// 0-код,он не изменяется и не проверяется
            if (data[i].contains("*")) {//если поле было изменено
                s = data[i].replaceAll("\\*", "");//убираем звездочку
                switch (i) {
                    case 1://тип
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isTypeWatermeter(s)) {error = "Поле \"" + name_column[i] + "\" имеет неверный формат!";return -1;}
                        if (s.length() > 10) {error = "Поле \"" + name_column[i] + "\" содержит много символов!";return -1;}
                        break;
                    case 2://инвентарный номер
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"" + name_column[i] + "\" должно содержать только цифры!";return -1;}
                        if (s.length() !=6) {error = "Поле \"" + name_column[i] + "\" должно содержать 6 символов!";return -1;}
                        break;
                    case 3://заводской номер
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"" + name_column[i] + "\" должно содержать только цифры!";return -1;}
                        if (s.length() !=8) {error = "Поле \"" + name_column[i] + "\" должно содержать 8 символов!";return -1;}
                        if(!isUnique(s)){error="В системе не может существовать несколько водомеров с одним и тем же заводским номером! Введите правильный номер!";return -1;}
                        break;
                    case 4://год выпуска
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"" + name_column[i] + "\" должно содержать только цифры!";return -1;}
                        if (s.length() !=4) {error = "Поле \"" + name_column[i] + "\" должно содержать 4 символа!";return -1;}
                        break;
                    case 6://калибр
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"" + name_column[i] + "\" должно содержать только цифры!";return -1;}
                        if (s.length() >4) {error = "Поле \"" + name_column[i] + "\" должно содержит много символов!";return -1;}
                        break;
                    case 9://начальные показания
                    case 12://последние показания
                        if (s.equals("")) {error = "Поле \"" + name_column[i] + "\" не может быть пустым!"; return -1;}
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"" + name_column[i] + "\" должно содержать только цифры!";return -1;}
                        if (s.length() > 6) {error = "Поле \"" + name_column[i] + "\" должно содержит много символов!";return -1;}
                        break;
                    case 5://поверка
                    case 8://дата установки
                    case 10://ввод в экпл.
                    case 11://опломбирован
                    case 13://дата установки
                        if (s.equals("null")) {error = "Поле \""+name_column[i]+"\" не может быть пустым!";return -1;
                    } else {
                        date = format.parse(s);
                        if (date.after(cur_date)) {error = "Поле \"" + name_column[i] + "\" не может быть больше текущей даты!";return -1;}
                    }
                        break;
                }
            }
        return  0;
    }
    /*
    * Метод проверяет поле "заводской номер" на уникальность.
    * Возвращает true - если в базе еще нет водомера с таким номером
    * Иначе false
    * */
    private static boolean isUnique(String serial_num) throws SQLException {
        String query = "select * from watermeter where serial_num = "+serial_num;
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            statement.close();
            return false;
        }else{
            statement.close();
            return true;
        }
    }
    /*
     * Метод ищет ВП по введенным данным из формы (data)
     */
    public static int searchWatermeterFromJournal(String[] data) throws SQLException {
        watermeter=null;
        String column[]=Methods.getColumnName("watermeter").split(" ");
        String query = "select * from  watermeter where ";
        for (int i = 0; i < data.length; i++)
            if (data[i] != null)
                query += column[i] + "=\"" + data[i] + "\"" + " and ";
        if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
        return receivingQueryForSearch(query, true);
    }
    /*
     * Метод добавляет в бд новый водомер
     * Принимает данные
     * Возвращает 0  - нет ошибок, -1 -ошибка
     */
    public static int addWatermeter(String[] new_data) throws ParseException, SQLException {
        if (new_data[7].equals("НЕ ВЫБРАНО")) {
            error = "Выберите код водомерного подключения!";
            return -1;
        }
        if (new_data[8].equals("НЕ ВЫБРАНО")) {
            error = "Выберите состояние!";
            return -1;
        }
        if (new_data[9].equals("НЕ ВЫБРАНО")) {
            error = "Выберите кем установлен водомер!";
            return -1;
        }
        String data[] = new String[15];
        data[0]=new_data[7];//код ВП
        data[1]=new_data[0];//тип
        data[2]=new_data[1];//инвентарный номер
        data[3]=new_data[2];//серийный номер
        data[4]=new_data[3];//год выпуска
        data[5]=new_data[13];//дата поверки
        data[6]=new_data[4];//калибр
        data[7]=new_data[9];//установлен
        data[8]=new_data[10];//дата установки
        data[9]=new_data[5];//начальные показания
        data[10]=new_data[11];//ввод в экспл.
        data[11]=new_data[12];//опломбирован
        data[12]=new_data[6];//последние показания
        data[13]=new_data[14];//дата снятия последних показаний
        data[14]=new_data[8];//статус

        //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
        for (int i = 0; i < data.length; i++) data[i] += "*";
        if (checkWatermeterFields(data) != 0) return -1;//проверка на корректность
        for (int i = 0; i < data.length; i++) data[i] = data[i].replaceAll("\\*", "");//удаление звездочек
        receiveQueryNewWatermeter(data);
        return 0;

    }
    /*
     * Метод составляет запрос на добавление нового водомера и выполняет его
     */
    private static void receiveQueryNewWatermeter(String[] data) throws SQLException {
        String[] column = Methods.getColumnName("watermeter").split(" ");
        String query = "insert into watermeter (";
        for (String aColumn : column) query += aColumn + ",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query += ") values (";
        for (String aData : data) query += "\"" + aData + "\",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query += ")";
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.close();
    }
}
