package ClassesForWork;
/*
 * Created by Юлия on 27.04.2017.
 */
import java.sql.Connection;
import java.sql.ResultSet;

public class Connect {
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
    public static ResultSet rs;
    static Connection connection;

    public static void  conntoDB () throws Exception{
        DBProcessor db = new DBProcessor();
        connection = db.getConnection(URL, USERNAME, PASSWORD);//подключение
    }
    public static void close() throws  Exception{
        connection.close();
    }

}
