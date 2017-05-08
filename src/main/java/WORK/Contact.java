package WORK;

import GUI.GContacts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Юлия on 08.05.2017.
 */
public class Contact {
    public static int num_account;
    public static String FIO;
    public static String post;
    public static String email;
    public static String telephone;

    public static Statement statement;
    public static Contact contact;

    public Contact(int num_account, String FIO, String post, String email, String telephone
    ) {
        this.num_account = num_account;
        this.FIO = FIO;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
    }


    public static int searchContact(String num_account) throws SQLException {
        contact = null;
        String query = "select * from contacts_company where num_account = \"" + num_account + "\"";
        return receivingQueryForSearch(query, true);
    }

    /*
   * Выполнение запроса к таблице Contact
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
                contact = new Contact(
                        resSet.getInt("num_account"),
                        resSet.getString("FIO"),
                        resSet.getString("post"),
                        resSet.getString("email"),
                        resSet.getString("telephone")
                );
                if (inTable) {
                    GContacts.AddRowTable(contact);//запись в таблицу
                } else {
                    // getNamesFromIndexes(account.adres, account.bank, type);//получить названия по индексам
                }

            }
            statement.close();
            return 0;//что-то найдено
        }
        statement.close();
        return -1;//не найдено
    }

    /*
    * Метод получает наименование компании
    * Принимает номер лицевого счета
    * Возвращает название компании
    * */
    public static String getCompany(String num_acc) throws SQLException {
        String query = "select name_company from account_company where num_account = " + num_acc;
        String company = "";
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                company = resSet.getString("name_company");
            }
            return company;
        }
        return "no company";
    }
}
