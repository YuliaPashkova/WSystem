package WORK;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Access {
    //login - admin pass- Julia
    //login - elena_pet pass -Sevastopol
    //login - NikOpl pass-mynameis12
    //login - oksana_sevas pass - 123oksana

    public static String name_operator;//ФИО оператора
    public static int access;//тип доступа
    public static int id;//id
    private static Statement statement;
    /**
     * Метод принимает логин и пароль
     * Получает значение хэш функции по введенному паролю
     * Достает значение хэш функции из БД
     * Возвращает
     * 1- логин и пароль введены верно
     * 2- логин или пароль введены не верно
     * 3- ни логин ни пароль не введены
     * 4- не введен логин
     * 5- не введен пароль
     */
    public static int login(String username, String password) throws SQLException, IOException {

        if(username.equals("")&&password.equals("")) return 3;//ни логин ни пароль не введены
        if(username.equals(""))return 4;//не введен логин
        if(password.equals("")) return 5;//не введен пароль
        String hash_pass = new Stribog(256).getHash(password);//получение значения функции хэширования введенного пароля
        String pass_bd = getHashDB(username);//полученное значение хэш функции из БД
        if(pass_bd.equals(hash_pass)) {
            access = getAccess(username);//получаем тип доступа
            name_operator = getFIO(username);//получаем ФИО
            id = getId(username);//получаем ИД
            return 1;//все ок
        }
        return 2;//логин или пароль неверен

    }
    private static String getHashDB(String username) throws SQLException {
        String query = "select password from operator where login =\""+username+"\"";
        String res = "";
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            if (resSet.next())
                res = resSet.getString("password");
        }
        statement.close();
        return  res;
    }
    /*
     * Вызывается только в том случае, когда логин и пароль введены верно
     * Принимает имя пользователя
     * Получает тип доступа
     * 1 – все права, 2 – старший оператор, 3- младший оператор
     */
    private static int getAccess(String username) throws SQLException {
        statement = Connect.connection.createStatement();
        int acs = 0;
        ResultSet resSet = statement.executeQuery("select access from operator where login =\""+username+"\"");
        if (resSet.next())
            acs = resSet.getInt("access");//получаем идентификатор доступа из БД
        statement.close();
        return acs;
    }
    /*
    Метод получает ФИО по логину
     */
    private static String getFIO(String username) throws SQLException {
        statement = Connect.connection.createStatement();
        String fio = "";
        ResultSet resSet = statement.executeQuery("select FIO from operator where login = \""+username+"\"");
        if (resSet.next())
            fio = resSet.getString("FIO");//получаем FIO
        statement.close();
        return fio;
    }
    private static int getId(String username) throws SQLException {
        statement = Connect.connection.createStatement();
        int id = 0;
        ResultSet resSet = statement.executeQuery("select id from operator where login = \""+username+"\"");
        if (resSet.next())
            id = Integer.parseInt(resSet.getString("id"));//получаем id
        statement.close();
        return id;
    }
}
