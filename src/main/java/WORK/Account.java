package WORK;
import GUI.GAccount;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Created by Юлия on 02.05.2017.
 */
public class Account  {

    public static Account account;
    static Statement statement;

    public int num_account;
    //физ.лицо
    public String FIO;

    public double balance;
    public Date date_contract;
    public int num_contract;

    public int adres;

    public String owner_flat;
    public String cons_type;
    public String telephone;
    public String acc_status;

    //юр.лицо
    public int bank;
    public int kpp;
    public int bik;
    public long pay_account;
    public long num_cert;
    public long INN;
    public String name_company;

    public Account() {
    }
    //для юр.лиц
    public Account(int num_account,
                   String FIO,
                   double balance,
                   Date date_contract,
                   int num_contract,
                   int adres,
                   String owner_flat,
                   String cons_type,
                   String telephone,
                   String acc_status,
                   int bank,
                   int kpp,
                   int bik,
                   long pay_account,
                   long num_cert,
                   long INN,
                   String name_company
    ) {
        this.num_account = num_account;
        this.FIO =FIO;
        this.balance = balance;
        this.date_contract = date_contract;
        this.num_contract = num_contract;
        this.adres=adres;
        this.owner_flat = owner_flat;
        this.cons_type = cons_type;
        this.telephone = telephone;
        this.acc_status = acc_status;
        this.bank = bank;
        this.kpp = kpp;
        this.bik = bik;
        this.pay_account = pay_account;
        this.num_cert = num_cert;
        this.INN = INN;
        this.name_company = name_company;
    }
    //для физ.лиц
    public Account(int num_account,
                   String FIO,
                   double balance,
                   Date date_contract,
                   int num_contract,
                   int adres,
                   String owner_flat,
                   String cons_type,
                   String telephone,
                   String acc_status
    ) {
        this.num_account = num_account;
        this.FIO =FIO;
        this.balance = balance;
        this.date_contract = date_contract;
        this.num_contract = num_contract;
        this.adres=adres;
        this.owner_flat = owner_flat;
        this.cons_type = cons_type;
        this.telephone = telephone;
        this.acc_status = acc_status;
    }

    /*
    Метод формирует запрос для поиска лицевого счета
    Принимает массив с данными и флаг place. Если place = "fields" - осуществляется поиск по данным из формы,
    если table - по выбранной строке из таблицы
    */
    public static int searchAccount(String data[], String place) throws Exception {
        //для place == "fields"
        //сначала нужно проверить,заполнено хотя бы одно поле из адреса (улица,дом,кв,корпус,индекс)
        //если заполнено,нужно выполнить запрос поиска по таблице adress и получить подходящие id_adress
        //затем искать в таблице account по введенным полям и id_adress
        //затем нужно проверить,заполнено ли хотя бы одно поле для юр.лиц
        //если заполнено, то составить запрос на объединение двух таблиц через JOIN

        //для place == "table"
        //получить номер лицевого счета из таблицы и сделать запрос к двум таблицам

        String column_account[] = Methods.getColumnName("watermeter.account").split(" ");//получение имен колонок таблицы account
        //подсчет пустых полей
        int counter = 0;
        for (String d : data) if (!(d == null)) counter++;// нахождение количества ненулевых критериев запроса
        if (counter == 0) return -1;//если введена пустая строка

        if (place == "fields") {
            //обработка адреса
            String address[] = new String[6];
            System.arraycopy(data, 10, address, 0, 6);//копирование полей адреса
            data[5] = checkAddress(address);//проверка,заполнено ли хотя бы одно поле адреса и формирование индексов подходящих адресов
            if(data[5].equals("not found"))return  -1;//ничего не найдено,дальше нет смысла проверять
            //если поля для юр.лиц не заполнены
            if (data[16] == null && data[17] == null && data[18] == null && data[19] == null && data[20] == null && data[21] == null && data[22] == null) {
                //начало запроса
                String query = "select * from  watermeter.account where ";
                for (int i = 0; i < column_account.length; i++)
                    if (i != 5 && i != 1)//5- поле адреса,оно добавится в конце,1- ФИО,добавится в конце
                        if (data[i] != null)
                            query += column_account[i] + "='" + data[i] + "'" + " and ";
                if (data[5] != "empty")
                    query += "adres IN " + data[5] + " and "; //если адрес не пуст,добавляем в запрос
                if (data[1] != null) query += "FIO like '%" + data[1] + "%'";
                if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
                System.out.println(query);

                account = new Account();
                return account.receivingQuery(query,true,true); //0-найдено,-1-не найдено
            }
            //если заполнено хотя бы одно поле для юр.лиц
            else {
                //начало запроса
                String query = "select * from  account JOIN account_company ON account.num_account=account_company.num_account WHERE ";
                //формирование запроса как для физ.лиц
                for (int i = 0; i < column_account.length; i++)
                    if (i != 5 && i != 1)//5- поле адреса,оно добавится в конце,1- ФИО,добавится в конце
                        if (data[i] != null)
                            query += "account." + column_account[i] + "='" + data[i] + "'" + " and ";
                if (data[5] != "empty")
                    query += "adres IN " + data[5] + " and "; //если адрес не пуст,добавляем в запрос
                if (data[1] != null) query += "FIO like '%" + data[1] + "%'";

                //получение индекса банка
                if(data[16]!=null) data[16]=Integer.toString(getIndex(data[16],4));//теперь вместо названия банка, хранится его индекс
                //получение имен колонок таблицы account_company
                String column_account_comp[] = Methods.getColumnName("watermeter.account_company").split(" ");
                int i,j;//переменные цикла
                //i - пробег по column_account_company, c 1 - так как первая колонка это num_account и она уже есть в запросе
                //j-пробег по данным с 16 по 22 ячейку (поля для юр.лиц)
                //формирование запроса для юр.лиц
                for (i = 1,j=16; i < column_account_comp.length && j<data.length; i++,j++)
                    if (j != 22 )//22- название компании,добавиться в конце
                        if (data[j] != null)
                            query += "account_company." + column_account_comp[i] + "='" + data[j] + "'" + " and ";
                if (data[22] != null) query += "account_company.name_company like '%" + data[22] + "%'";
                if (query.endsWith(" and ")) query = query.substring(0, query.length() - " and ".length());
                System.out.println(query);

                account = new Account();
                return  account.receivingQuery(query, true,false);
            }
        }
        //if place=table
        else{
            return 0;
        }
    }

    //возвращает индексы подходящих адресов (таблица adres)
    public static String checkAddress(String addres[]) throws Exception {
        int id_district,id_street,id_index;
        int count=0;//счетчик нулевых полей
        String indexes="(";//здесь будут хранится все подходящие индексы адресов (результат метода)
        String query = "select id_adres from  watermeter.adres where ";
        for (int i = 0; i < 6; i++)
            if (!(addres[i] == null))//если i-ое поле заполнено
                switch (i) {
                    case 0://район
                        id_district=getIndex(addres[0],0);//получаем индекс района, передаем название района
                        query+="id_district = "+id_district+" and ";
                        break;
                    case 1://улица
                        id_street=getIndex(addres[1],1);//получаем индекс улицы, передаем название улицы
                        query+="id_street = "+id_street+" and ";
                        break;
                    case 2://дом
                        query+="house = "+addres[2]+" and ";
                        break;
                    case 3://корпус
                        query+="corpus = "+addres[3]+" and ";
                        break;
                    case 4://квартира
                        query+="flat = "+addres[4]+" and ";
                        break;
                    case 5:
                        id_index=getIndex(addres[5],2);//получаем индекс индекса, передаем индекс
                        query+="id_index = "+id_index;
                        break;
                }
            else{
                  count++;
            }
        if(count==6)//все пусто
                return "empty";//пустые поля адреса
        //обрезаем последний and
        if(query.endsWith(" and ")) query=query.substring(0, query.length()-" and ".length());
        //выполняем запрос
        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                indexes+=Integer.toString(resSet.getInt("id_adres"))+",";
            }
            //обрезаем последнюю запятую
            if(indexes.endsWith(",")) indexes=indexes.substring(0, indexes.length()-",".length());
            //добавляем скобку для IN
            indexes+=")";
            return indexes;
        }
        return "not found";//по данному адресу ничего не найдено

    }

    /*
    * Метод формирует и выполняет запрос на получение индексов района,улицы,индекса,банка
    * Принимает строкое значеие и флаг what: 0 - район, 1 - улица,2 - индекс,3 - банк
    * Возвращает индекс района,улицы,индекса,банка
    * */
    private static int getIndex(String data,int what) throws Exception {
        String query;
        int ind=-1;//здесь будет хранится полученный индекс

        if(what==0) query = "select id from watermeter.cat_district where district = \"" + data+"\"";
        else if(what==1) query = "select id from watermeter.cat_street where street = \"" + data+"\"";
        else if(what==2) query="select id from watermeter.cat_index where indx = " + data;
        else query="select id from watermeter.cat_bank where bank = \"" + data+"\"";

        statement = Connect.connection.createStatement();
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                ind=resSet.getInt("id");
            }
        }
        return  ind;
    }

    /*
    * Выполнение запроса к таблице Account
    * boolean inTable - заполняется таблица из формы,иначе - из таблицы в форму
    * boolean type -  true - физ.лицо,false - юр.лицо
    * */
    public int receivingQuery(String q, boolean inTable, boolean type) throws Exception {
        ResultSet resSet = null; //отправка запроса
        Account account;
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                if(type)
                 account= new Account(
                        resSet.getInt("num_account"),
                        resSet.getString("FIO"),
                        resSet.getDouble("balance"),
                        resSet.getDate("date_contract"),
                        resSet.getInt("num_contract"),
                        resSet.getInt("adres"),
                        resSet.getString("owner_flat"),
                        resSet.getString("cons_type"),
                        resSet.getString("telephone"),
                        resSet.getString("acc_status")
                );
                else
                    account= new Account(
                            resSet.getInt("num_account"),
                            resSet.getString("FIO"),
                            resSet.getDouble("balance"),
                            resSet.getDate("date_contract"),
                            resSet.getInt("num_contract"),
                            resSet.getInt("adres"),
                            resSet.getString("owner_flat"),
                            resSet.getString("cons_type"),
                            resSet.getString("telephone"),
                            resSet.getString("acc_status"),
                            resSet.getInt("bank"),
                            resSet.getInt("kpp"),
                            resSet.getInt("bik"),
                            resSet.getLong("pay_account"),
                            resSet.getLong("num_cert"),
                            resSet.getLong("INN"),
                            resSet.getString("name_company")
                    );
                if (inTable)
                    GAccount.AddRowTable(account);//запись в таблицу
            }
            return 0;//что-то найдено
        }
        return -1;//не найдено
    }
}