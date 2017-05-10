package WORK;
import GUI.GAccount;
import GUI.GContacts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Created by Юлия on 08.05.2017.
 */
public class Contact {
    public static String company;
    public static int id;
    public static String FIO;
    public static String post;
    public static String email;
    public static String telephone;
    public static Contact contact;
    public static String error;//текст ошибки
    private static int num_account;
    private static Statement statement;

    private Contact(int id, int num_account, String FIO, String post, String email, String telephone
    ) {
        Contact.id =id;
        Contact.num_account = num_account;
        Contact.FIO = FIO;
        Contact.post = post;
        Contact.email = email;
        Contact.telephone = telephone;
    }

    /*
    Метод формирует запрос для поиска контактного лица по номеру аккаунта
    Принимает номер аккаунта
    */
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
                        resSet.getInt("id"),
                        resSet.getInt("num_account"),
                        resSet.getString("FIO"),
                        resSet.getString("post"),
                        resSet.getString("email"),
                        resSet.getString("telephone")
                );
                if (inTable) {
                    GContacts.AddRowTable();//запись в таблицу
                } else {
                     company=getCompany(Integer.toString(num_account));//получить название компании
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
    /*
     Метод формирует запрос для отображения данных контакта в форму,
     по ИД (полученного из таблицы)
     Принимает ИД
     */
    public static void showContact(String id) throws SQLException {
        String query = "select * from contacts_company where id = "+id;
        receivingQueryForSearch(query,false);

    }
    /*
     * Метод удаляет контактное лицо с ИД=id
     */
    public static void deleteContact(String id) {
        String query = "delete from contacts_company where id=" + id;
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
  * Метод анализирует новые данные и изменяет в БД
  * Возвращает
  * 0 - без ошибок
  * -1 - ошибка
  * Принимает new_data - новые данные, String id - ид
  * */
    public static int changeContact(String[] new_data, String id) throws SQLException {
        String data [] = new String[4];
        data [0]=new_data[0]+" "+new_data[1]+" "+new_data[2];//фио
        data [1]=new_data[3];//должность
        data [2]=new_data[5];//email
        data [3]=new_data[4];//телефон
        int result = checkContactFields(data);//проверка полей  на содержимое
            if (result == 0) receivingQueryForChanging(data,id);//изменение полей
            else return result;
        return  0;
    }
    /*
     * Метод изменяет данные контакта
     * Принимает новые данные и ИД контакта
     */
    private static void receivingQueryForChanging(String[] data,String id) throws SQLException {
        String  [] c= Methods.getColumnName("contacts_company").split(" ");
        String [] column=new String[4];
        System.arraycopy(c, 2, column, 0, 4);//копирование полей (для того,что бы обрезать столбец ИД)
        String query = "update contacts_company set ";
        for (int i = 0; i < data.length; i++)//с 1 - так как номер лицевого счета не изменяется
            if (data[i].contains("*"))//поле содержит звездочку
                query += column[i] + " = \"" + data[i].replaceAll("\\*", "") + "\",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length());
        query += " where id = " + id;
        //выполняем запрос
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Метод проверяет содержимое полей на корректность
    * Возващает 0 - если нет ошибок
    * -1 - если ошибка
    * */
    private static int checkContactFields(String[] data) {
            String s;
            for (int i = 0; i < data.length; i++)// 0-номер аккаунта,он не изменяется и не проверяется
                if (data[i].contains("*")) {//если поле было изменено
                    s = data[i].replaceAll("\\*", "");//убираем звездочку
                    switch (i) {
                        case 0://фио
                            String fio[] = s.trim().split("\\s\\s*");//длина должна быть равна 3 ( ФИО)
                            if ((s.replaceAll(" ", "").equals("")) || fio.length != 3) {
                                error = "Поле \"ФИО\" не может быть пустым!";
                                return -1;
                            }
                            if (s.length() > 100) {//проверка фио
                                error = "Поле \"ФИО\" содержит много символов!";
                                return -1;
                            }
                            if (!Methods.isLetter(s)) {
                                error = "Поле \"ФИО\" должно содержать только буквы!";
                                return -1;
                            }
                            break;
                        case 1://должность
                            if (s.equals("")){
                                error = "Поле \"Должность\" не может быть пустым!";
                                return -1;
                            }
                            if (s.length() > 45) {
                                error = "Поле \"Должность\" содержит много символов!";
                                return -1;
                            }
                            if (!Methods.isLetter(s)) {
                                error = "Поле \"Должность\" должно содержать только буквы!";
                                return -1;
                            }
                            break;
                        case 2://email
                            if (s.length() > 45) {
                                error = "Поле \"Email\" содержит много символов!";
                                return -1;
                            }
                            if (!Methods.isEmail(s)&&!s.equals("")) {
                                error = "Поле \"Email\" имеет неверный формат!";
                                return -1;
                            }
                            break;
                        case 3://телефон
                            if (s.equals("")) {
                                error = "Поле \"Телефон\" не может быть пустым!";
                                return -1;
                            }
                            if (!Methods.isOnlyDigit(s)) {
                                error = "Поле \"Телефон\" должно содержать только цифры!";
                                return -1;
                            }
                            if (s.length() > 11) {
                                error = "Поле \"Телефон\" содержит много символов!";
                                return -1;
                            }
                            break;
                    }
                }
            return  0;
        }
    /*
     * Метод добавляет в бд новое контактное лицо
     * Принимает данные
     * Возвращает 0  - нет ошибок, -1 -ошибка
     */
    public static int addContact(String[] new_data) throws SQLException {
        String data [] = new String[4];
        data [0]=new_data[0]+" "+new_data[1]+" "+new_data[2];//фио
        data [1]=new_data[3];//должность
        data [2]=new_data[5];//email
        data [3]=new_data[4];//телефон
        //добавление всем полям звездочки (признак новых данных,для проверки их на корректность)
        for (int i=0;i<data.length;i++)data[i]+="*";
        if(checkContactFields(data)!=0)return -1;//проверка на корректность
        for (int i=0;i<data.length;i++)data[i]=data[i].replaceAll("\\*","");//удаление звездочек
        //новый массив с номером счета
        String d []= new String[5];
        d[0]=GAccount.NUM_ACC;
        System.arraycopy(data,0,d,1,4);
        receiveQueryNewContact(d);//добавить
        return  0;
    }
    /*
    * Метод составляет запрос на добавление нового контактного лица и выполняет его
    */
    private static void receiveQueryNewContact(String[] d) throws SQLException {
        String column[]=Methods.getColumnName("contacts_company").split(" ");
        String query = "insert into contacts_company(";
        for (int i=1;i<column.length;i++)query+=column[i]+",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query+=") values (";
        for (String aD : d) query += "\"" + aD + "\",";
        if (query.endsWith(",")) query = query.substring(0, query.length() - ",".length()); //обрезаем последнюю запятую
        query+=")";
        statement = Connect.connection.createStatement();
        try {
            statement = Connect.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.close();
    }
}
