package WORK;
/*
 * Created by Юлия on 27.04.2017.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String URL = "jdbc:mysql://localhost:3306/watermeter";
    public static ResultSet rs;
    static Connection connection;

    public static void  conntoDB () throws Exception{
        DBProcessor db = new DBProcessor();
        connection = db.getConnection(URL, USERNAME, PASSWORD);//подключение
    }
    public static void close() throws  Exception{
        connection.close();
    }
    //для выпадающих списков
    public static void retrieveStreet() throws SQLException {//улица
        Statement stmt=connection.createStatement();
        String query="select street from watermeter.cat_street";
        rs = stmt.executeQuery(query);
    }
    public static void retrieveBank() throws SQLException {//банк
        Statement stmt=connection.createStatement();
        String query="select bank from watermeter.cat_bank";
        rs = stmt.executeQuery(query);
    }
    public static void retrieveIndex() throws SQLException {//индекс
        Statement stmt=connection.createStatement();
        String query="select indx from watermeter.cat_index";
        rs = stmt.executeQuery(query);
    }


}
