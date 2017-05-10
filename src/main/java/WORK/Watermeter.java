package WORK;
import GUI.GWatermeter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private static Watermeter watermeter;
    private static Statement statement;

    private  Watermeter(
            int code_watcon,
            String type,
            int inv_num,
            int serial_num,
            int year_release,
            Date date_check,
            int caliber,
            String installed,
            Date date_set,
            int prim_indications,
            Date enter_exploit,
            Date seal,//опломбирован
            int last_indications,
            Date check_last_indic,
            String status){
        Watermeter.code_watcon=code_watcon;
        Watermeter.type =type;
        Watermeter.inv_num =inv_num;
        Watermeter.serial_num =serial_num;
        Watermeter.year_release =year_release;
        Watermeter.date_check =date_check;
        Watermeter.caliber =caliber;
        Watermeter.installed =installed;
        Watermeter.date_set =date_set;
        Watermeter.prim_indications =prim_indications;
        Watermeter.enter_exploit =enter_exploit;
        Watermeter.seal =seal;
        Watermeter.last_indications =last_indications;
        Watermeter.check_last_indic =check_last_indic;
        Watermeter.status =status;
    }

    /*
     Метод формирует запрос для поиска водомера по коду ВП
     Принимает код ВП
     */
    public static int searchWatermeter(String code) throws SQLException {
        String query = "select * from watermeter where code_watcon = \"" + code + "\"";
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
                watermeter = new Watermeter(
                        resSet.getInt("code_watcon"),
                        resSet.getString("type"),
                        resSet.getInt("inv_num"),
                        resSet.getInt("serial_num"),
                        resSet.getInt("year_release"),
                        resSet.getDate("date_check"),
                        resSet.getInt("caliber"),
                        resSet.getString("installed"),
                        resSet.getDate("date_set"),
                        resSet.getInt("prim_indications"),
                        resSet.getDate("enter_exploit"),
                        resSet.getDate("seal"),
                        resSet.getInt("last_indications"),
                        resSet.getDate("check_last_indic"),
                        resSet.getString("status")
                );
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
}
