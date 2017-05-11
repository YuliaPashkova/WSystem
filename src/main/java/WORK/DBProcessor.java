package WORK;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;
/*
 * Created by Юлия on 27.04.2017.
 */
class DBProcessor {
    public static  Connection connection;
    DBProcessor() throws Exception{
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    Connection getConnection(String url, String username, String password) throws Exception{
        if(connection!= null)
            return connection;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

}
