package WORK;
import GUI.GJournalOrders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static WORK.Methods.getColumnName;

/*
 * Created by Юлия on 11.05.2017.
 */

public class Order {
    public static String error;
    public static Order order;
    public static int num_order;
    public static String status;
    public static Date date_compl;
    public static double summ;
    public static Date date_form;
    public static int operator;
    public static String type_work;
    public static String note;
    public static int serial_num_wm;
    public static int num_account;
    private static Statement statement;

    /*
    * Метод возвращает последний номер заказа в таблице ordering
    */
    public static int getLastNumber() throws SQLException {
        int number=-1;
        String query = "select MAX(num_order) AS result from ordering";
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                number=resSet.getInt("result");
            }
            statement.close();
            return  number;
        }
        statement.close();
        return number;
    }
    /*
     * Метод добавляет в бд новый заказ
     * Принимает данные
     * Возвращает 0  - нет ошибок, -1 -ошибка
     */
    public static int addOrder(String[] data) throws ParseException, SQLException {
        if (data[7].equals("НЕ ВЫБРАНО")) {
            error = "Выберите тип работы!";
            return -1;
        }
        if (checkOrdersFields(data) != 0) return -1;//проверка на корректность
        receiveQueryNewOrder(data);
        return 0;
    }
    /*
     * Метод составляет запрос на добавление нового заказа и выполняет его
     */
    private static void receiveQueryNewOrder(String[] data) throws SQLException {
        String[] column = Methods.getColumnName("ordering").split(" ");
        String query = "insert into ordering (";
        for(int i=0;i<8;i++)query+=column[i]+",";
        query+=column[9];//номер аккаунта
        query += ") values (";
        for(int i=1;i<data.length;i++)query += "\"" + data[i] + "\",";
        query +=data[0]+ ")";//номер аккаунта
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
     * Метод проверяет содержимое полей на корректность
     * Возващает 0 - если нет ошибок
     * -1 - если ошибка
     */
    private static int checkOrdersFields(String[] data) throws ParseException {
        for (int i = 3; i < data.length; i++)//0,1,2-проверять не надо,они формируются автоматически
            switch (i){
                case 3://дата выполнения
                    if (data[i].equals("null")) {error = "Поле \"Дата выполнения\" не может быть пустым!";return -1;
                    } else {
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = format.parse(data[i]);
                        java.util.Date cur_date = new java.util.Date();
                        if (date.before(cur_date)) {
                            error = "Поле \"Дата выполнения\" не может быть меньше текущей даты!";
                            return -1;
                        }
                    }
                    break;
                case 4://сумма
                    if (data[i].equals("")) {error = "Поле \"Сумма\" не может быть пустым!";return -1;}
                    if (data[i].contains(",")) {data[i] = data[i].replaceAll(",", ".");}
                    if (data[i].equals(".")) {error = "Неправильный формат поля \"Сумма\"!";return -1;}
                    if (!Methods.isDigit(data[i])) {error = "Поле \"Сумма\" должно содержать только цифры!";return -1;
                    }
                    if (data[i].equals("0")) {data[i] = "0.00";return 0;}
                    if (data[i].contains(".")) {String[] balance = data[i].split("\\.");//делим на дробную и целую части
                        if (balance[1].length() > 2) {//проверка дробной части
                            error = "Дробная часть поля \"Сумма\" должна содержать не более двух цифр!";
                            return -1;
                        }
                    } else {
                        if (data[i].length() > 6) {error = "Поле \"Сумма\" превышает максимальное значение!";return -1;}
                    }
                    break;
                case 8://примечание
                    if (data[i].length() > 100) {error = "Поле \"Примечание\" содержит много символов!";return -1;}
            }
            return 0;
    }

    /*
    Метод формирует запрос для поиска заказа по данным,полученным из формы
    Принимает массив с данными
    */
    public static int searchOrder(String[] data) throws SQLException {
        order = null;
        String column[] = getColumnName("ordering").split(" ");//получение имен колонок таблицы account
        String query = "select * from  ordering where ";
        for (int i = 0; i < data.length; i++)
            if (data[i] != null)
                query += column[i] + "=\"" + data[i] + "\"" + " and ";
        if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
        return receivingQueryForSearch(query, true);

    }
    /*
   * Выполнение запроса к таблице ordering
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
                num_order=resSet.getInt("num_order");
                status=resSet.getString("status");
                date_compl=resSet.getDate("date_compl");
                summ=resSet.getDouble("summ");
                date_form=resSet.getDate("date_form");
                operator=resSet.getInt("operator");
                type_work=resSet.getString("type_work");
                note=resSet.getString("note");
                serial_num_wm=resSet.getInt("serial_num_wm");
                num_account=resSet.getInt("num_account");
                if (inTable) {
                    GJournalOrders.AddRowTable();//запись в таблицу
                }
            }
            statement.close();
            return 0;//что-то найдено
        }
        statement.close();
        return -1;//не найдено

    }
    /*
    * Метод возвращает айди оператора по его ФИО
    * */
    public static int getIdOperatorFromName(String name) throws SQLException {
        String query="select id from operator where FIO = \""+name+"\"";
        int id=-1;
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                      id=  resSet.getInt("id");

            }
            statement.close();
            return id;
        }
        statement.close();
        return id;//не найдено
    }
}
