package WORK;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Created by Юлия on 09.05.2017.
 */
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
        String pass_bd="";//полученное значение хэш функции из БД
        if(username.equals("")&&password.equals("")) return 3;//ни логин ни пароль не введены
        if(username.equals(""))return 4;//не введен логин
        if(password.equals("")) return 5;//не введен пароль
        Stribog stribog = new Stribog(256);
        String hash_pass = stribog.getHash(password);//получение значения функции хэширования введенного пароля
        String query = "select password from operator where login =\""+username+"\"";
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                pass_bd = resSet.getString("password");
            }
        }
        statement.close();
        if(pass_bd.equals(hash_pass)) {
            getAccess(username);//получаем тип доступа
            getFIO(username);//получаем ФИО
            getId(username);//получаем ИД
            return 1;//все ок
        }
        else{
            return 2;//логин или пароль неверен
        }
    }
    /*
     * Вызывается только в том случае, когда логин и пароль введены верно
     * Принимает имя пользователя
     * Получает тип доступа
     * 1 – все права, 2 – старший оператор, 3- младший оператор
     */
    private static int getAccess(String username) throws SQLException {
        String query = "select access from operator where login =\""+username+"\"";
        statement = Connect.connection.createStatement();

        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            access = resSet.getInt("access");//получаем идентификатор доступа из БД
        }
        statement.close();
        return access;
    }
    /*
    Метод получает ФИО по логину
     */
    private static void getFIO(String username) throws SQLException {
        String query = "select FIO from operator where login = \""+username+"\"";
        statement = Connect.connection.createStatement();

        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            name_operator = resSet.getString("FIO");//получаем FIO
        }
        statement.close();
    }
    private static void getId(String username) throws SQLException {
        String query = "select id from operator where login = \""+username+"\"";
        statement = Connect.connection.createStatement();

        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            id = Integer.parseInt(resSet.getString("id"));//получаем id
        }
        statement.close();
    }
}
