package WORK;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

/*
 * Created by Rob on 11.05.2017.
 * Класс реализует создание отчета по должникам в формате ПДФ
 */
public class ReportDebtors {
    private static final String RESULT = "D:\\ReportDeptors.pdf";
    private static Font font, fontNameTable, fontHead, fontDolg; //для данных в таблице, для имени таблицы, для заголовков таблицы, для долга
    /*
     * Формирует отчет по должникам в формате PDF
     * @param acc - массив лицевых счетов
     */
    public static void createReport(String acc[]) throws Exception {
        //получаем всю информацию для документа
        String info [][] = getInfoAccount(acc);
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
            fontNameTable = new Font(baseFont, 24, Font.NORMAL); //заголовок
            fontHead = new Font(baseFont, 16, Font.NORMAL); //имена колонок таблицы
            fontDolg = new Font(baseFont, Font.DEFAULTSIZE, Font.NORMAL, new BaseColor(250, 0, 0)) {

            };
        }catch (Exception ignored){}
        PdfPCell cell = new PdfPCell(new Phrase("Информация о должниках\n ", fontNameTable));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(9);
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
        for(int i = 0; i < info.length; i++){
            table.addCell(new Phrase(acc[i], font));
            table.addCell(new Phrase(changeFormatData(info[i][0]), font));
            table.addCell(new Phrase(info[i][1], fontDolg));
            table.addCell(new Phrase(info[i][2], font));
            table.addCell(new Phrase(changeFormatData(info[i][3]), font));
            table.addCell(new Phrase(changeFormatData(info[i][4]), font));
            table.addCell(new Phrase(info[i][5], font));
            table.addCell(new Phrase(info[i][6], font));
            table.addCell(new Phrase(info[i][7], font));
        }
        document.add(table);
        document.close();

    }
    /*
     * Выполняет преобразование строки
     * what - строка формата 'AAA [AAA+]'
     * return - строка формата 'Aaa [Aaa]+'
     */
    private static String changeFormatData(String what){
        String array[] = what.split(" ");
        String s = "";
        for (String anArray : array)
            s += anArray.charAt(0) + anArray.replaceAll(anArray.substring(0, anArray.length()),
                    anArray.substring(1, anArray.length()).toLowerCase()) + " ";
        s=s.substring(0, s.length()-" ".length());
        return s;
    }

    /*
     * Собирает информацию по лицевым счетам
     * @param acc - массив лицевых счетов с долгом
     * @return String[] - информация по кадому абоненту
     */
    private static String[][] getInfoAccount(String acc[]) throws Exception {
        String res [][] = new String[acc.length][8]; //все абоненты
        Connect.conntoDB();
        String query = "select FIO , balance, telephone, district, street, house, corpus, flat\n" +
                "from watermeter.account, watermeter.adres, watermeter.cat_district, watermeter.cat_street\n" +
                "where (account.adres =  adres.id_adres) " +
                "and adres.id_district = cat_district.id\n" +
                "and adres.id_street = cat_street.id";
        Statement statement = Connect.connection.createStatement();
        for(int i = 0; i < acc.length; i++){ //по каждому лицевому счету добываем информацию
            ResultSet resSet = statement.executeQuery(query+" and num_account = "+acc[i]);
            while (resSet.next()) {
                //очередной абонент
                res[i][0] = resSet.getString("FIO");
                res[i][1] = String.valueOf(resSet.getInt("balance"));
                res[i][2] = resSet.getString("telephone");
                res[i][3] = resSet.getString("district");
                res[i][4] = resSet.getString("street");
                res[i][5] = resSet.getString("house");
                res[i][6] = resSet.getString("corpus");
                res[i][7] = String.valueOf(resSet.getInt("flat"));
            }
        }
        statement.close();
        return  res;
    }
}


