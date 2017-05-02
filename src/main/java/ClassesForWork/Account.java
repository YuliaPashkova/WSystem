package ClassesForWork;
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
    public int pay_account;
    public int num_cert;
    public int INN;
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
                   int pay_account,
                   int num_cert,
                   int INN,
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
    Принимает массив с данными и флаг place. Если fields - осуществляется поиск по данным из формы,
    если table - по выбранной строке из таблицы
    */
    public static int searchAccount(String data[], String place) throws Exception {

        //для place == "fields"

        //сначала нужно проверить,заполнено хотя бы одно поле из адреса (улица,дом,кв,корпус,индекс)
        //если заполнено,нужно выполнить запрос поиска по таблице adress и получить подходящие id_adress
        //затем искать в таблице account по введенным полям и id_adress

        //затем нужно проверить,заполнено ли хотя бы одно поле для юр.лиц
        //если заполнено, то искать по этим полям в таблице account_company (получить num_acc каждой найденной записи)
        //если  при этом заполнены некоторые поля из физ.лиц,то искать в account (получить num_acc каждой найденной записи)
        //затем сравнить,совпадают ли номер лицевого счета из первого запроса и второго
        //если совпадают,то вывести данные по этому лицевому счету,иначе - не найдено
        //если в первом случае найдено 0,то проверять в таблице физ.лиц уже не надо,  и необорот. Результат - не найдено

        //ИЛИ через JOIN

        //для place == "table"
        //получить номер лицевого счета из таблицы и сделать запрос к двум таблицам

        if(place=="fields"){
            //подсчет пустых полей
            int counter = 0;
            for (String d : data) if (!(d == null)) counter++;// нахождение количества ненулевых критериев запроса
            if (counter == 0) return -1;//если введена пустая строка

            //обработка адреса
            String address[] = new String[6];
            System.arraycopy(data, 10, address, 0, 6);//копирование полей адреса
            data[5] =checkAddress(address);//проверка,заполнено ли хотя бы одно поле адреса и формирование индексов подходящих адресов

            //начало запроса
            String query = "select * from  watermeter.account where ";
            //получение имен колонок таблицы
            String column[] = Methods.getColumnName("watermeter.account").split(" ");

            for (int i = 0; i < column.length; i++)
                if(i!=5&&i!=1)//5- поле адреса,оно добавится в конце,1- ФИО,добавится в конце
                    if (data[i]!=null)
                        query += column[i] + "='" + data[i] + "'" + " and ";
            if(data[5]!="empty")  query+="adres IN "+data[5]+" and "; //если адрес не пуст,добавляем в запрос
            if(data[1]!=null) query +="FIO like '%"+data[1]+"%'";
            if(query.endsWith(" and ")) query=query.substring(0, query.length()-" and ".length());
            System.out.println(query);

            account = new Account();
            account.receivingQueryPhys(query, true);

        }
        return  0;
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
                        id_district=getStreetIndex(addres[0],0);//получаем индекс района, передаем название района
                        query+="id_district = "+id_district+" and ";
                        break;
                    case 1://улица
                        id_street=getStreetIndex(addres[1],1);//получаем индекс улицы, передаем название улицы
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
                        id_index=getStreetIndex(addres[5],2);//получаем индекс индекса, передаем индекс
                        query+="id_index = "+id_index;
                        break;
                }
            else{
                  count++;
            }
        if(count==6)//все пусто
                return "empty";
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
        }
        //обрезаем последнюю запятую
        if(indexes.endsWith(",")) indexes=indexes.substring(0, indexes.length()-",".length());
       //добавляем скобку для IN
        indexes+=")";
        return indexes;
    }

    /*
    * Метод формирует и выполняет запрос на получение индексов района,улицы,индекса
    * Принимает строкое значеие и флаг what: 0 - район, 1 - улица,2 - индекс
    * Возвращает индекс района,улицы,индекса
    * */
    private static int getStreetIndex(String data,int what) throws Exception {
        String query;
        int ind=-1;//здесь будет хранится полученный индекс

        if(what==0) query = "select id from watermeter.cat_district where district = \"" + data+"\"";
        else if(what==1) query = "select id from watermeter.cat_street where street = \"" + data+"\"";
        else query="select id from watermeter.cat_index where indx = " + data;

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
    * boolean inTable - заполняется таблица из формы,иначе - из таблицы в формы
    * */
    public int receivingQueryPhys(String q, boolean inTable) throws Exception {
        ResultSet resSet = null; //отправка запроса
        try {
            statement = Connect.connection.createStatement();
            resSet = statement.executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resSet != null && resSet.isBeforeFirst()) {
            while (resSet.next()) {
                Account account = new Account(
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
                if (inTable)
                    GAccount.AddRowTable(account);//запись в таблицу
            }
            return 1;
        }
        account = null;
        return -1;
    }

}