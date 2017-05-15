package WORK;
import GUI.GAccount;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
/*
 * Created by Юлия on 15.05.2017.
 */
public class NoticeDept {
    //формирует документ
    //принимает pattern:true - шабло извещения, false - извещение абоненту
    public static void makeNoticeDept(boolean pattern) {
        String data []=null;//данные об абоненте
        try {
            XWPFDocument docxModel = new XWPFDocument();// создаем модель docx документа
            XWPFParagraph Paragraph = docxModel.createParagraph(); // создаем шапку
            Paragraph.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun paragraphConfig = Paragraph.createRun();
            installFormat(paragraphConfig,"Times New Roman", 12, "000000" ); //установка нужного формата для текста

            //записываем шапку в документ


            if(pattern)//если шаблон
            writeData(
                    paragraphConfig,
                    "Абоненту\n_______________________\nАдрес\n"+
                            "_______________________\n_______________________\n"+
                            "ГУПС «Водоканал»\nОператор\n_______________________\n"+
                            "Адрес\n299011\nг. Севастополь\nул. Адм. Октябрьского, 4\n"
            );
            else {
                data= getData(GAccount.NUM_ACC);
                writeData(
                        paragraphConfig,
                        "Абоненту\n"+ReportDebtors.changeFormatData(data[0])+"\nАдрес\n"+
                                ReportDebtors.changeFormatData(data[1])+"\n"+
                                "ГУПС «Водоканал»\nОператор\n"+Access.name_operator+"\n"+
                                "Адрес\n299011\nг. Севастополь\nул. Адм. Октябрьского, 4\n"
                );
            }

            // создаем название документа
            XWPFParagraph Paragraph3 = docxModel.createParagraph();
            Paragraph3.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun paragraphConfig3 = Paragraph3.createRun();
            installFormat(paragraphConfig3,"Times New Roman", 12, "000000" ); //установка нужного формата для текста

            //записываем шапку в документ
            writeData(
                    paragraphConfig3,
                    " \n Извещение"
            );


            //создаем тело документа
            XWPFParagraph Paragraph2 = docxModel.createParagraph();
            Paragraph2.setAlignment(ParagraphAlignment.NUM_TAB);
            XWPFRun paragraphConfig2 = Paragraph2.createRun();
            installFormat(paragraphConfig2,"Times New Roman", 12, "000000" ); //установка нужного формата для текста

            //записываем тело в документ

            if(pattern)//шаблон извещения
            writeData(
                    paragraphConfig2,
                    "              Уважаемый абонент __________________,"+ " ГУПС «Водоканал» напоминает вам о долге"+
                            " в размере ______ рублей. Оплату за услуги водоснабжения и водоотведения " +
                            "можно произвести на открытый рублевый счет в следующем банке: \n"+
                            "ГУПС \"Водоканал\" ОКПО 00328137 \n" +
                            "ИНН 9204507194 \n" +
                            "КПП 920401001 \n" +
                            "РНКБ Банк (ПАО) \n" +
                            "БИК 043510607 \n" +
                            "Кор. счет 30101810335100000607 \n" +
                            "р/с 40602810140030000006 \n" +
                            "ОГРН 1149204066307 \n"+
                            " \n \n \n \n \n \n \n \n \n \n" +
                            getDate() +
                            "                                                                                                                       Подпись"
            );
            else{//извещение
                writeData(
                        paragraphConfig2,
                        "              Уважаемый абонент "+ReportDebtors.changeFormatData(data[0]) + ", ГУПС «Водоканал» напоминает вам о долге"+
                                " в размере "+Methods.Zero(data[2])+" (руб.). Оплату за услуги водоснабжения и водоотведения " +
                                "можно произвести на открытый рублевый счет в следующем банке: \n"+
                                "ГУПС \"Водоканал\" ОКПО 00328137 \n" +
                                "ИНН 9204507194 \n" +
                                "КПП 920401001 \n" +
                                "РНКБ Банк (ПАО) \n" +
                                "БИК 043510607 \n" +
                                "Кор. счет 30101810335100000607 \n" +
                                "р/с 40602810140030000006 \n" +
                                "ОГРН 1149204066307 \n"+
                                " \n \n \n \n \n \n \n \n \n \n" +
                                getDate() +
                                "                                                                                                                       Подпись"
                );
            }

            // формируем документ
            FileOutputStream outputStream = new FileOutputStream("D:\\NoticeDeptPattern.docx");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Desktop.getDesktop().open(new File("D:\\NoticeDeptPattern.docx"));
        } catch (Exception ignore){}
    }

    /*
     * Пишет необходимые данные в модель будущего документа
     * doc - модель документа
     * dt - данные для записи
     */
    private static void writeData(XWPFRun doc, String dt) {
        String[] data = dt.split("\n");

        for(int i =0; i< data.length; i++){
            doc.setText(data[i]);
            if(i!= data.length-1)  doc.addBreak();
        }
    }
    /*
     * Возвращает текующую дату в формате dd.mm.yyyy
     */
    public static String getDate(){
        Locale local = new Locale("ru","RU"); //русскоязычный формат даты
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
        Date currentDate = new Date();
        return df.format(currentDate);
    }

    /*
     * Форматирует текст
     * r - модель будущего документа, к которой применяется формат
     * font - имя шрифта
     * size - размер текста
     * color - цвет в формате ХХХХХХ
     */
    private static void installFormat(XWPFRun r, String font, int size, String color)  {
        r.setFontFamily(font);
        r.setFontSize(size);
        r.setColor(color);
    }

    //получает данные об абоненте
    //принимает номер аккаунта
    //возвращает массив с данными
    private static String[] getData(String num_acc) throws Exception {
        String res [] = new String[3]; //массив результата
        String query = "select FIO , balance, street, house, corpus, flat " +
                "from watermeter.account, watermeter.adres, watermeter.cat_street " +
                "where (account.adres =  adres.id_adres) " +
                "and adres.id_street = cat_street.id and num_account = "+num_acc;
        Connect.conntoDB();
        Statement statement = Connect.connection.createStatement();
        ResultSet resSet = statement.executeQuery(query);
            while (resSet.next()) {
                //очередной абонент
                res[0] = resSet.getString("FIO");
                res[1] = resSet.getString("street")+", д. "+ resSet.getString("house");
                if(!resSet.getString("corpus").equals(""))res[1]+=", к. "+resSet.getString("corpus");
                if(!resSet.getString("flat").equals(""))res[1]+=", кв."+resSet.getString("flat");
                res[2] = String.valueOf(resSet.getDouble("balance"));
            }
        statement.close();
        return  res;
        }
}
