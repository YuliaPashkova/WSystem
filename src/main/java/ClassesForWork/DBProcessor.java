package ClassesForWork;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;
/*
 * Created by Юлия on 27.04.2017.
 */
public class DBProcessor {
    public static  Connection connection;
    public DBProcessor() throws Exception{
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public Connection getConnection(String url, String username, String password) throws Exception{
        if(connection!= null)
            return connection;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

}
