package WORK;
import GUI.GWaterconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static String  note;//пометка
    public static int num_account;//номер аккаунта
    private static Statement statement;

    private Waterconnection(int code, String num_TY, Date date_TY, String status, String owner, int object_con,
                            String type_con, String owner_ter, String location, int depth, String note, int num_account){
        Waterconnection.code =code;
        Waterconnection.num_TY =num_TY;
        Waterconnection.date_TY =date_TY;
        Waterconnection.status =status;
        Waterconnection.owner =owner;
        Waterconnection.object_con =object_con;
        Waterconnection.type_con =type_con;
        Waterconnection.owner_ter =owner_ter;
        Waterconnection.location =location;
        Waterconnection.depth =depth;
        Waterconnection.note =note;
        Waterconnection.num_account =num_account;
    }
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
                waterconnection= new Waterconnection(
                        resSet.getInt("code"),
                        resSet.getString("num_TY"),
                        resSet.getDate("date_TY"),
                        resSet.getString("status"),
                        resSet.getString("owner"),
                        resSet.getInt("object_con"),
                        resSet.getString("type_con"),
                        resSet.getString("owner_ter"),
                        resSet.getString("location"),
                        resSet.getInt("depth"),
                        resSet.getString("note"),
                        resSet.getInt("num_account")
                );
                if (inTable) {
                    GWaterconnection.AddRowTable();//запись в таблицу
                } else {
                    obj_str=getObjectFromIndex(object_con);
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
        String query = "select object_con from cat_object where id = "+id;
        String object="";
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
        String query = "select * from waterconnection where code = "+code;
        receivingQueryForSearch(query,false);
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
}
