package WORK;
import GUI.GAccount;
import GUI.GWaterconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Created by Юлия on 09.05.2017.
 */
public class Waterconnection {
    public static String error;//текст ошибки
    public static Waterconnection waterconnection;
    public static String obj_str;//объект подключения,его название
    public static int code;//код ВП
    public static String num_TY;//номер ТУ
    public static Date date_TY;//дата ТУ
    public static String status;//статус
    public static String owner;//владелец
    public static int object_con;//объект подключения
    public static String type_con;//тип подключения
    public static String owner_ter;//владелец территории
    public static String location;//местонахождение
    public static int depth;//глубина
    public static String note;//пометка
    public static int num_account;//номер аккаунта
    private static Statement statement;

    /*
     Метод формирует запрос для поиска водомерного подключения по номеру аккаунта
     Принимает номер аккаунта
     */
    public static int searchWaterconnection(String num_account) throws SQLException {
        waterconnection = null;
        String query = "select * from waterconnection where num_account = \"" + num_account + "\"";
        return receivingQueryForSearch(query, true);
    }

    /*
     * Выполнение запроса к таблице waterconnection
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
                code = resSet.getInt("code");
                num_TY = resSet.getString("num_TY");
                date_TY = resSet.getDate("date_TY");
                status = resSet.getString("status");
                owner = resSet.getString("owner");
                object_con = resSet.getInt("object_con");
                type_con = resSet.getString("type_con");
                owner_ter =resSet.getString("owner_ter");
                location = resSet.getString("location");
                depth = resSet.getInt("depth");
                note =resSet.getString("note");
                num_account = resSet.getInt("num_account");
                if (inTable) {
                    GWaterconnection.AddRowTable();//запись в таблицу
                } else {
                    obj_str = getObjectFromIndex(object_con);
                }
            }
            statement.close();
            return 0;//что-то найдено
        }
        statement.close();
        return -1;//не найдено
    }

    /*
    * Метод принимает индекс объекта подключения
    * Возвращает его наименование
    */
    public static String getObjectFromIndex(int id) throws SQLException {
        String query = "select object_con from cat_object where id = " + id;
        String object = "";
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                object = resSet.getString("object_con");
            }
            return object;
        }
        return "no object";
    }

    /*
     Метод формирует запрос для отображения данных ВП в форму,
     по коду ВП (полученного из таблицы)
     Принимает код
     */
    public static void showWaterconnection(String code) throws SQLException {
        String query = "select * from waterconnection where code = " + code;
        receivingQueryForSearch(query, false);
    }

    /*
     * Метод удаляет ВП с code
     */
    public static void deleteWaterconnection(String code) {
        String query = "delete from waterconnection where code=" + code;
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
     * Принимает new_data - новые данные
     * */
    public static int changeWaterconnection(String[] new_data) throws SQLException, ParseException {
        String data[] = new String[11];
        data[0] = new_data[0];//код
        data[1] = new_data[1];//номер ТУ
        data[2] = new_data[9];//дата ТУ
        data[3] = new_data[6];//статус
        data[4] = new_data[7];//владелец
        data[5] = new_data[2];//объект подключения
        data[6] = new_data[8];//тип подключения
        data[7] = new_data[3];//владелец территории
        data[8] = new_data[4];//местонахождение
        data[9] = new_data[5];//глубина
        data[10] = new_data[10];//примечание
        int result = checkWaterconnectionFields(data);//проверка полей  на содержимое
        if (result == 0) receivingQueryForChanging(data);//изменение полей
        else return result;
        return 0;
    }

    /*
     * Метод изменяет данные ВП
     * Принимает новые данные
     */
    private static void receivingQueryForChanging(String[] data) throws SQLException {
        String[] column = Methods.getColumnName("waterconnection").split(" ");
        String query = "update waterconnection set ";
        for (int i = 1; i < data.length; i++)//с 1 - так как код ВП не изменяется
            if (data[i].contains("*")) { //поле содержит звездочку
                if (i == 5) {//если это объект подключения
                    int id_object = getIndexOfObject(data[i].replaceAll("\\*", ""));//получаем индекс объекта подключения
                    if (id_object == -1) {//если нет,то добавить в базу
                        addNewData(data[i].replaceAll("\\*", ""));
                        id_object = getIndexOfObject(data[i].replaceAll("\\*", ""));//получаем индекс нового объекта подключения
                    }
                    query += column[i] + " = \"" + id_object + "\",";
                } else query += column[i] + " = \"" + data[i].replaceAll("\\*", "") + "\",";
            }
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query += " where code = " + data[0];
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
     * Метод добавляет в базу данных новый объект подключения
     */
    private static void addNewData(String s) throws SQLException {
        String query = "insert into cat_object (object_con) values (\"" + s + "\")";
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
    * Метод формирует и выполняет запрос на получение индекса объекта подключения
    * Принимает строкое значеие
    * Возвращает индекс
    * */
    public static int getIndexOfObject(String s) throws SQLException {
        String query = "select id from cat_object where object_con = \"" + s + "\"";
        int ind = -1;
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
     * Метод проверяет содержимое полей на корректность
     * Возващает 0 - если нет ошибок
     * -1 - если ошибка
     */
    private static int checkWaterconnectionFields(String[] data) throws ParseException {
        String s;
        for (int i = 0; i < data.length; i++)// 0-код,он не изменяется и не проверяется
            if (data[i].contains("*")) {//если поле было изменено
                s = data[i].replaceAll("\\*", "");//убираем звездочку
                switch (i) {
                    case 1://номер ТУ
                        if (s.equals("")) {error = "Поле \"Номер ТУ\" не может быть пустым!";return -1;}
                        if (!Methods.isLetterOrDigit(s)) {error = "Поле \"Номер ТУ\" должно содержать только цифры или буквы!";return -1;}
                        if (s.length() > 8) {error = "Поле \"Номер ТУ\" содержит много символов!";return -1;}
                        break;
                    case 2://дата ТУ
                        if (s.equals("null")) {error = "Поле \"Дата ТУ\" не может быть пустым!";return -1;
                        } else {
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date date = format.parse(s);
                            java.util.Date cur_date = new java.util.Date();
                            if (date.after(cur_date)) {
                                error = "Поле \"Дата ТУ\" не может быть больше текущей даты!";
                                return -1;}}
                        break;
                    case 5://объект подключения
                        if (s.equals("")) {error = "Поле \"Объект подключения\" не может быть пустым!";return -1;}
                        if (!Methods.isLetter(s)) {error = "Поле \"Объект подключения\" должно содержать только буквы!";return -1;}
                        if (s.length() > 20) {error = "Поле \"Объект подключения\" содержит много символов!";return -1;}
                        break;
                    case 7://владелец территории
                        if (s.equals("")) {error = "Поле \"Принадлежность территории\" не может быть пустым!";return -1;}
                        if (!Methods.isOwnerTerrit(s)) {error = "Поле \"Принадлежность территории\" может содержать только бувы, цифры и знак \"минус\"!";return -1;}
                        if (s.length() > 10) {error = "Поле \"Принадлежность территории\" содержит много символов!";return -1;}
                        break;
                    case 8://местонахождение
                        if (s.length() > 45) {error = "Поле \"Местонахождение\" содержит много символов!";return -1;}
                        break;
                    case 9://глубина
                        if (s.equals("")) {error = "Поле \"Глубина\" не может быть пустым!";return -1;
                        }
                        if (!Methods.isOnlyDigit(s)) {error = "Поле \"Глубина\" может содержать только цифры!";return -1;}
                        if (s.length() > 2) {error = "Поле \"Глубина\" содержит много символов!";return -1;}
                    case 10://примечание
                        if (s.length() > 100) {error = "Поле \"Примечание\" содержит много символов!";return -1;}
                        break;
                }
            }
        return 0;
    }

    /*
     * Метод добавляет в бд новое ВП
     * Принимает данные
     * Возвращает 0  - нет ошибок, -1 -ошибка
     */
    public static int addWaterconnection(String[] new_data) throws ParseException, SQLException {

        if (new_data[6].equals("НЕ ВЫБРАНО")) {
            error = "Выберите состояние!";
            return -1;
        }
        if (new_data[7].equals("НЕ ВЫБРАНО")) {
            error = "Выберите принадлежность ВП!";
            return -1;
        }
        if (new_data[8].equals("НЕ ВЫБРАНО")) {
            error = "Выберите вид подключения!";
            return -1;
        }

        String data[] = new String[11];
        data[0] = new_data[0];//код
        data[1] = new_data[1];//номер ТУ
        data[2] = new_data[9];//дата ТУ
        data[3] = new_data[6];//статус
        data[4] = new_data[7];//владелец
        data[5] = new_data[2];//объект подключения
        data[6] = new_data[8];//тип подключения
        data[7] = new_data[3];//владелец территории
        data[8] = new_data[4];//местонахождение
        data[9] = new_data[5];//глубина
        data[10] = new_data[10];//примечание

        //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
        for (int i = 0; i < data.length; i++) data[i] += "*";
        if (checkWaterconnectionFields(data) != 0) return -1;//проверка на корректность
        for (int i = 0; i < data.length; i++) data[i] = data[i].replaceAll("\\*", "");//удаление звездочек


        int id_object = getIndexOfObject(new_data[2]);
        if (id_object == -1) {
            addNewData(new_data[2]);//добавляем новый объект
            id_object = getIndexOfObject(new_data[2]);//получаем индекс
        }
        data[5] = String.valueOf(id_object);//объект подключения

        receiveQueryNewWaterconnection(data);
        return 0;
    }

    /*
     * Метод составляет запрос на добавление нового ВП и выполняет его
     * */
    private static void receiveQueryNewWaterconnection(String[] data) throws SQLException {
        String[] column = Methods.getColumnName("waterconnection").split(" ");
        String query = "insert into waterconnection (";
        for (String aColumn : column) query += aColumn + ",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query += ") values (";
        for (String aData : data) query += "\"" + aData + "\",";
        query += GAccount.NUM_ACC;
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

    /*
    * Метод получает последний код ВП в таблице waterconnection
    * */
    public static int getLastCode() throws SQLException {
        String query = "select MAX(code) AS result from waterconnection";
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
    * Метод ищет ВП по введенным данным из формы (data)
    * */
    public static int searchWaterconnectionFromJournal(String[] data) throws SQLException {
        waterconnection = null;
        String column[] = Methods.getColumnName("waterconnection").split(" ");
        String query = "select * from  waterconnection where ";
        for (int i = 0; i < data.length; i++)
            if (data[i] != null)
                query += column[i] + "=\"" + data[i] + "\"" + " and ";

        if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
        return receivingQueryForSearch(query, true);
    }

    /*
    * Метод ищет все ВП по лицевому счету
    * Возвращает строку кодов ВП
    * */
    public static String showWaterconnectionForWatermer(String num_account) throws SQLException {
        String nums = "НЕ ВЫБРАНО";
        String query = "select code from waterconnection where num_account = " + num_account;
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                nums =nums+"_"+String.valueOf(resSet.getInt("code"));
            }
            statement.close();
            return nums.trim();
        }
        return nums;
    }
    //метод проверяет, существуют ли водомерные подключения на лицевом счете
    //возвращает true - есть, false - нет
    public static boolean existWatercon(String num_account) throws SQLException {
        String query = "select code from waterconnection where num_account = "+num_account;
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            statement.close();
            return true;
        }
        statement.close();
        return false;
    }
}
