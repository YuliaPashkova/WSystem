package WORK;


import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

/*
 * Класс для удобства хранения информации по каждому абоненту
 */
class InfoAbonent{
    String fio, tel, district, street, corpus;
    int balance, house, flat;

    InfoAbonent(String f, int b, String t, String d, String s, int h, String c, int fl){
        fio = f; balance = b; tel = t; district = d; street = s; house = h; corpus = c; flat = fl;
    }
}

/*
 * Created by Rob on 11.05.2017.
 * Класс реализует создание отчета по должникам в формате ПДФ
 */
public class ReportDebtorsNaturalPerson {
    /**
     * TODO куда писать результат !!!
     * 
     */
    private static final String RESULT = "F:\\Report.pdf";
    private static Font font, fontNameTable, fontHead, fontDolg; //для данных в таблице, для иммени таблицы, для заголовков таблицы, для долга

    /*
     * Формирует отчет по должникам в формате PDF
     * 
     * @param acc - массив лицевых счетов
     *
     */
    public static void createReport(int acc[]) throws Exception {
        //получаем всю информацию для документа
        InfoAbonent ia [] = getInfoAccount(acc);
        /*
         * формирование документа
         */
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(RESULT)).setInitialLeading(16);
        document.open();
        //колонки, 8 штук
        float[] columnWidths = {5, 5, 5, 5, 5, 5, 5, 5, 5};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        try{
            BaseFont baseFont = BaseFont.createFont("c:\\Windows\\Fonts\\tahoma.ttf", "cp1251", BaseFont.EMBEDDED);
            font = new Font(baseFont, Font.DEFAULTSIZE, Font.NORMAL); //данные
            fontNameTable = new Font(baseFont, 24, Font.ITALIC); //заголовок
            fontHead = new Font(baseFont, 16, Font.ITALIC); //имена колонок таблицы
            fontDolg = new Font(baseFont, Font.DEFAULTSIZE, Font.NORMAL, new BaseColor(250, 0, 0)) {

            };
        }catch (Exception ignored){}
        PdfPCell cell = new PdfPCell(new Phrase("Информация о должниках\n ", fontNameTable));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(9); //непонятно, почему 9, но работает
        table.addCell(cell);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        //заголовки
        table.addCell(new Phrase("№ лицевого счета", fontHead));
        table.addCell(new Phrase("ФИО", fontHead));
        table.addCell(new Phrase("Долг\n(руб)", fontHead));
        table.addCell(new Phrase("Телефон", fontHead));
        table.addCell(new Phrase("Район", fontHead));
        table.addCell(new Phrase("Улица", fontHead));
        table.addCell(new Phrase("Дом", fontHead));
        table.addCell(new Phrase("Корпус", fontHead));
        table.addCell(new Phrase("Квартира", fontHead));
        //информация
        for(int i = 0; i < ia.length; i++){
            table.addCell(new Phrase(String.valueOf(acc[i]), font));
            table.addCell(new Phrase(changeFormatData(ia[i].fio), font));
            table.addCell(new Phrase(String.valueOf(ia[i].balance), fontDolg));
            table.addCell(new Phrase(ia[i].tel, font));
            table.addCell(new Phrase(changeFormatData(ia[i].district), font));
            table.addCell(new Phrase(changeFormatData(ia[i].street), font));
            table.addCell(new Phrase(String.valueOf(ia[i].house), font));
            table.addCell(new Phrase(ia[i].corpus, font));
            table.addCell(new Phrase(String.valueOf(ia[i].flat), font));
        }
        document.add(table);
        document.close();

    }

    /**
     * Выполняет преобразование строки
     *
     * what - строка формата 'AAA [AAA+]'
     * return - строка формата 'Aaa [Aaa]+'
     *
     * **/
    private static String changeFormatData(String what){
        String array[] = what.split(" ");
        String s = "";
        for (String anArray : array)
            s += anArray.charAt(0) + anArray.replaceAll(anArray.substring(0, anArray.length()),
                    anArray.substring(1, anArray.length()).toLowerCase()) + " ";
        s=s.substring(0, s.length()-" ".length());
        return s;
    }

    /**
     * Собирает информацию по лицевым счетам
     * 
     * @param acc - массив лицевых счетов с долгом
     * @return InfoAbonent[] - информация по кадому абоненту
     */
    private static InfoAbonent[] getInfoAccount(int acc[]) throws Exception {
        InfoAbonent res [] = new InfoAbonent[acc.length]; //все абоненты
        Connect.conntoDB();
        String query = "select FIO , balance, telephone, district, street, house, corpus, flat\n" +
                "from watermeter.account, watermeter.adres, watermeter.cat_district, watermeter.cat_street\n" +
                "where (account.adres =  adres.id_adres) " +
                "and adres.id_district = cat_district.id\n" +
                "and adres.id_street = cat_street.id";
        Statement statement = Connect.connection.createStatement();
        InfoAbonent ia = new InfoAbonent("", 0, "", "","", 0, "-", 0);
        for(int i = 0; i < acc.length; i++){ //по каждому лицевому счету добываем информацию
            //к запросу добавляется очередной лицевой счет
            ResultSet resSet = statement.executeQuery(query + " and num_account =" + acc[i]);
            //пустой абонент, корпус по умолчанию "-"
            while (resSet.next()) {
                //очередной абонент
                ia.fio = resSet.getString("FIO");
                ia.balance = resSet.getInt("balance");
                ia.tel = resSet.getString("telephone");
                ia.district = resSet.getString("district");
                ia.street = resSet.getString("street");
                ia.house = resSet.getInt("house");
                ia.corpus = resSet.getString("corpus");
                ia.flat = resSet.getInt("flat");
            }
            //кидаем в результирующий массив
            res[i] = ia;
        }
        statement.close();
        return  res;
    }
}


