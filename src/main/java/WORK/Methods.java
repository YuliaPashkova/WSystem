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


}
