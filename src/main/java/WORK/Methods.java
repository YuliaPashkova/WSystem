package WORK;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Юлия on 02.05.2017.
 */
public class Methods {
    static Statement statement;

    /* Метод возвращает имена колонок таблицы
     * nameTable - имя таблицы, для которой надо получить массив имен колонок
     **/
    public static String getColumnName(String table) throws SQLException {
        String sql = "SELECT * from " + table;
        statement = Connect.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        String c = "";
        for (int i = 1; i <= count; i++)
            c += rsmd.getColumnName(i) + " ";
        return c;
    }
    /**
     * Рассчитывает суммарный баланс по лицевым счетам, которые находятся в таблице результата
     * Принимает строку,содержащую номера лицевых счетов
     * Возвращает суммарный баланс
     */
    public static double SumBalance(String num_accs) throws SQLException {
        String query;
        double balance = 0;
        String num_acc[] = num_accs.replaceAll("\\s+", " ").split(" ");
        for (String aNum_acc : num_acc) {
            query = "select balance from watermeter.account where num_account = " + aNum_acc;
            ResultSet resSet = statement.executeQuery(query); //отправка запроса
            while (resSet.next()) {
                balance += resSet.getDouble("balance");
            }
        }
        return balance;
    }
    /**
     * Добавляет нули к числу типа double, если требуется
     * Возвращает строку типа Х.00 | Х.Х0
     **/
    public static String Zero(String d) {
        String new_d = d;
        if ((!d.endsWith(".") && !d.contains("."))) {
            new_d = d + ".00"; //если целое, добавляем запятую
            return new_d;
        }
        String drob = d.substring(d.indexOf(".") + 1); //получаем дробную часть
        if (drob.length() == 1) new_d = d + "0"; //если в ней одно число, добавляем 0
        return new_d;
    }
    /*
    Метод сравнивает новые данные и старые данные. Если есть изменения,добавляет к старым данным звездочку
    */
    public static String []compareData(String[] old_data, String[] new_data) {
        for(int i=0;i<old_data.length;i++)
            if(!old_data[i].equals(new_data[i]))new_data[i]+="*";//если данные разные,то добавить звездочку
        return new_data;
    }
    /**
     * Метод подсчитывает и возвращает количество измененных полей
     **/
    public static int haveNewValues(String data[]) {
        int count = 0; //количество измененных полей
        for (String d : data)
            if (d.contains("*")) //есть *
                count++;
        return count;
    }
    /*
     * Проверяет входную строку на математическое число
     * Возвращает true | false
     */
    public static boolean isDigit(String str) {
        return str.matches("^[+-]?\\d+(\\.\\d+)?");
    }
    /*
    * Проверяет входную строку на состав цифр
    * Возвращает true | false
    */
    public static boolean isOnlyDigit(String str){
        return str.matches("\\d+");
    }
    /*
     * Проверяет входную строку на буквы
     * Возвращает true | false
     */
    public static boolean isLetter(String str) {
        return str.matches("^[[а-яА-Яa-zA-z]\\s]+$") & !str.matches("^\\d+(\\.\\d+)?");
    }
    /*
    * Проверяет входную строку на формат улицы
    * Возвращает true | false
    */
    public static boolean isStreet(String str){
        return  str.matches("[а-яА-Яa-zA-z]+[\\.\\s*[а-яА-Яa-zA-z0-9]+]+");
    }
    /*
    * Проверяет входную строку
    * Возвращает true: если строка содержит буквы,если строка содержит цифры,если строка содержит буквы и цифры
    * */
    public static boolean isLetterOrDigit(String str){
        return str.matches("[[а-яА-Яa-zA-z]*[0-9]*]*");
    }

    /*
   * Проверяет входную строку
   * Возвращает true: если строка подходит под формат email
   * */
    public static boolean isEmail(String str){
        return str.matches("[[0-9]*\\.*\\_*\\-*[a-zA-z]+\\.*\\_*\\-*[0-9]*]+\\@[a-zA-z]+\\.[a-zA-z]+");
    }
    /*
    * Проверяет входную строку
    * Возвращает true: если строка подходит под формат WWW-dd
    * */
    public static boolean isOwnerTerrit(String str) {
        return str.matches("[[а-яА-Яa-zA-z]*\\-*[0-9]*]*");
    }
    /*
    * Проверяет входную строку
    * Возвращает true: если строка подходит под формат типа водомера
    * */
    public static boolean isTypeWatermeter(String str) {
        return str.matches("[[а-яА-Яa-zA-z]+\\-*[0-9]*\\/*[0-9]*]+");
    }
}
