package WORK;

import java.io.*;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rob on 07.05.2017.
 * Реализует шифр Магма
 */
public class Magma {
    private final static int[] keyMap = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 7, 6, 5, 4, 3, 2, 1, 0};
    private final static byte table[][] = {
            {4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3},
            {14, 11, 4, 12, 6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9},
            {5, 8, 1, 13, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11},
            {7, 13, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3},
            {6, 12, 7, 1, 5, 15, 13, 8, 4, 10, 9, 14, 0, 3, 11, 2},
            {4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 8, 5, 9, 12, 15, 14},
            {13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12},
            {1, 15, 13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12}
    };

    private byte key[][] = new byte[8][4];
    private int sync[] = new int[8];

    private static PrintWriter log = null;

    //1 - ошибка, 0 - все отлично
    private int initKey(String pathKey) throws IOException {
        // пример:
        // byte k[][] = {
        //        {0x00, 0x11, 0x22, 0x33},//first 32 bit of key
        //        {0x04, 0x10, 0x34, 0x26},
        //       {0x30, 0x08, 0x02, 0x54},
        //       {0x46, 0x67, 0x21, 0x06},
        //       {0x34, 0x67, 0x76, 0x39},
        //       {0x14, 0x79, 0x51, 0x54},
        //       {0x25, 0x76, 0x00, 0x09},
        //      {0x58, 0x47, 0x29, 0x31} //all 256 bit
        // };
        try (BufferedReader in = new BufferedReader(new FileReader(pathKey))) {//В цикле построчно считываем файл
            File f = new File(pathKey);
            if (f.length() != 102 || !pathKey.endsWith(".txt")) throw new EOFException();
            String s;
            String temp[];
            int j = 0; //счетчик для строк (12)
            while ((s = in.readLine()) != null) {
                temp = s.split(" ");
                for (int i = 0; i < temp.length; i++)
                    key[j][i] = (byte) (Integer.parseInt(temp[i], 16));
                j++; //следующая 64-значная строка
            }
        } catch (FileNotFoundException ex) {
            log.println(getTime() + " Файл с ключом " + pathKey + " не найден.");
            log.println(getTime() + " Процесс остановлен.");
            log.close();
            return 1;
        } catch (EOFException | NumberFormatException ex) {
            log.println(getTime() + " Файл с ключом " + pathKey + " неверный или поврежден.");
            log.println("Формат файла с ключом должен иметь тип txt и содержать следующее:");
            log.println("   XX XX XX XX\n   XX XX XX XX\n   XX XX XX XX\n   XX XX XX XX");
            log.println("   XX XX XX XX\n   XX XX XX XX\n   XX XX XX XX\n   XX XX XX XX,");
            log.println("где ХХ - число в шестнадцатеричной системе счисления.");
            log.println("Пример ключа:\n   FF FF FF FF\n   FF FF FF FF\n   FF FF FF FF\n   FF FF FF FF\n" +
                    "   FF FF FF FF\n   FF FF FF FF\n   FF FF FF FF\n   FF FF FF FF\n");
            return 1;
        }
        return 0;
    }

    private int initSync(String pathSync) throws IOException {
        ////синхропосылка открытого типа
        //пример: 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28
        ///
        try (BufferedReader in = new BufferedReader(new FileReader(pathSync))) {
            File f = new File(pathSync);
            if (f.length() != 23 || !pathSync.endsWith(".txt")) throw new EOFException();
            String s = in.readLine();
            String temp[] = s.split(" ");
            for (int i = 0; i < temp.length; i++)
                sync[i] = (byte) (Integer.parseInt(temp[i], 16));
        } catch (FileNotFoundException ex) {
            log.println(getTime() + " Файл с начальным заполнителем " + pathSync + " не найден.");
            log.println(getTime() + " Процесс остановлен.");
            log.close();
            return 1;
        } catch (EOFException | NumberFormatException ex) {
            log.println(getTime() + " Файл с начальным заполнителем " + pathSync + " неверный или поврежден.");
            log.print("Формат файла с начальным заполнителем должен иметь тип txt и содержать следующее:");
            log.println("XX XX XX XX XX XX XX XX,");
            log.println("где ХХ - число в шестнадцатеричной системе счисления.");
            log.println("Пример начального заполнителя: FF FF FF FF FF FF FF FF");
            return 1;
        }
        return 0;
    }

    /**
     * Осуществляет дешифрование файлов, находящихся в pathIn
     *
     * @param pathIn - путь к папке с шифро-файлами
     * @param pathOut - путь к папке для результатов
     * @param pathKey - путь к файлу с ключом
     * @param pathSync - путь к файлу с синхропосылкой
     * @param pathLog - путь к файлу для лога
     */
    public static int decryption(String pathIn, String pathOut, String pathKey, String pathSync, String pathLog) throws Exception{

        return work(pathIn + "\\", pathOut + "\\", pathKey, pathSync, pathLog, 1);//1 - дешифрование
    }
    /**
     * Осуществляет шифрование файлов, находищхся в папке pathIn
     *
     * @param pathIn - путь к папке с sql-файлами
     * @param pathOut - путь к папке с шифро-файлами
     * @param pathKey - путь к файлу с ключом
     * @param pathSync - путь к файлу с синхропосылкой
     * @param pathLog - путь к файлу для лога
     *
     */
    public static int encryption(String pathIn, String pathOut, String pathKey, String pathSync, String pathLog) throws Exception{
        //0 - шифрование
        return work(pathIn + "\\", pathOut + "\\", pathKey, pathSync, pathLog, 0);
    }

    private static int work(String pathIn, String pathOut, String pathKey, String pathSync, String pathLog, int typeWork) throws Exception {
        Magma g = new Magma();
        //PrintWriter обеспечит возможности записи в файл
        log  = new PrintWriter(pathLog);
        log.println(g.getDate());
        log.print(g.getTime() + " Получаю список файлов... ");

        String[] files = g.getFiles(pathIn, typeWork);
        log.println(" в директории " + pathIn + " найдено " + files.length + " файла(ов).");
        if(files.length > 0) {
            log.println("Список файлов:");
            for (String file : files) log.println("    " + file);
        } else {
            log.println(g.getTime() + " Файлы не найдены.");
            log.println(g.getTime() + " Процесс остановлен.");
        }

        String fileType = typeWork == 1 ? ".sql" : ".mgm";

        log.println("\n" + g.getTime() + " Инициализирую массив ключей из файла " + pathKey);
        if(g.initKey(pathKey) == 1){
            log.println(g.getTime() + " Процесс остановлен.");
            log.close();
            return 1;
        }
        log.println(g.getTime() + " Инициализирую начальный заполнитель из файла " + pathSync);
        if(g.initSync(pathSync) == 1){
            log.println(g.getTime() +  " Процесс остановлен.");
            log.close();
            return 1;
        }

        log.println(g.getTime() + " В директории " + pathIn + " создаю директорию \"out\" для результата.");
        if(! new File(pathIn + "out").mkdirs()){
            log.println(g.getTime() + " Директория уже сущесвует.");
        }

        log.println("\n" + g.getTime() + " Процесс " + (typeWork == 0? "шифрования" : "дешифрования") + " начат...");
        log.println("________________________________");
        //шифруем синхропосылку
        //N(N1, N2)
        int N[] = g.SimpleReplacMode(g.sync);

        //синхропосылка = начальный заполнитель РГПЧ
        //шифруем в режиме простой замены
        N = g.SimpleReplacMode(N);
        //на основе шифрованной синхропосылки получаем первое число из РГПЧ
        N = g.GeneratorOfNumber(N);

        for (String file : files) {
            log.println(g.getTime() + " Работаю с файлом \"" + file + "\"");
            processingOfByte(N, g, pathIn, pathOut, file, fileType);
            log.println(g.getTime() + " Файл \"" + file + "\" успешно " + (typeWork == 0 ? " зашифрован" : " дешифрован"));
            log.println("________________________________");
        }

        log.println(g.getTime() +  " Процесс завершен.\n");
        log.close();
        return 0; //all ok

    }
    private static void processingOfByte(int N[], Magma g, String pathIn, String pathOut, String file1, String fileType) throws Exception {
        byte data[] = new byte[8]; //данные для шифрования
        DataInputStream dis = new DataInputStream(new FileInputStream(pathIn + file1));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathOut + "out\\" + file1.substring(0, file1.length() - 4) + fileType));
        int count = dis.read(data);//читает в data и возвращает кол-во считанных байтов в count
        while (count != -1) {
            //шифруем первое число
            N = g.SimpleReplacMode(N);
            //за раз может зашифровать 2х32 бит данных
            byte N0[] = new byte[]{(byte) ((N[0] & 0xFF000000L) >> 24), (byte) ((N[0] & 0x00FF0000) >> 16), (byte) ((N[0] & 0x0000FF00) >> 8), (byte) (N[0] & 0x000000FF)};
            byte N1[] = new byte[]{(byte) ((N[1] & 0xFF000000L) >> 24), (byte) ((N[1] & 0x00FF0000) >> 16), (byte) ((N[1] & 0x0000FF00) >> 8), (byte) (N[1] & 0x000000FF)};
            //N01 = N0 + N1
            byte N01[] = new byte[8];
            System.arraycopy(N0, 0, N01, 0, N0.length);
            System.arraycopy(N1, 0, N01, 4, N1.length);

            for (int w = 0; w < count; w++)
                data[w] = (byte) (data[w] ^ N01[w]);

            dos.write(data, 0, count); //пишем столько байт, сколько считали
            count = dis.read(data);

            //получаем новое псевдослучайное число на основе прошлого шифрованного
            if (count != -1) N = g.GeneratorOfNumber(N);
        }
        dis.close();
        dos.close();
    }
    private int[] SimpleReplacMode(int [] N) throws Exception {
        byte[] B = new byte[4];
        byte[] A = new byte[4];
        //берем ByteBuffer, выделяем в нем 4 байта и
        // кладем число int 8, затем все это (0, 0, 0, 8) преобразуем в массив типа byte с помощью вызова array())
        byte data[] = ByteBuffer.allocate(4).putInt(N[0]).array();
        System.arraycopy(data, 0, B, 0, 4);
        data = ByteBuffer.allocate(4).putInt(N[1]).array();
        System.arraycopy(data, 0, A, 0, 4);

        for (int k = 0; k < 32; k++) {
            byte[] K = key[keyMap[k]];
            int buf = ByteBuffer.wrap(A).getInt() + ByteBuffer.wrap(K).getInt();
            buf &= 0xffffffff; // A + K (mod 2^32)
            int[] s = {
                    (buf & 0xF0000000) >>> 28,
                    (buf & 0x0F000000) >>> 24,
                    (buf & 0x00F00000) >>> 20,
                    (buf & 0x000F0000) >>> 16,
                    (buf & 0x0000F000) >>> 12,
                    (buf & 0x00000F00) >>> 8,
                    (buf & 0x000000F0) >>> 4,
                    (buf & 0x0000000F)
            };
            buf = 0x00000000;
            for (int b = 0; b < 8; b++) {
                buf <<= 4;
                buf += table[b][s[b] & 0x0000000f];
            }
            buf = ((buf << 11) | (buf >>> 21));
            byte[] resBytes = ByteBuffer.allocate(4).putInt(buf).array();
            byte[] newB = {0x00, 0x00, 0x00, 0x00};

            System.arraycopy(A, 0, newB, 0, 4);
            for (int b = 0; b < 4; b++) {
                A[b] = (byte) (resBytes[b] ^ B[b]);
            }
            System.arraycopy(newB, 0, B, 0, 4);
        }
        //собираем байты в int обратно N(N1, N2)
        return new int[]{
                ( (A[0] & 0xFF) << 24) + ((A[1] & 0xFF) << 16) + ((A[2] & 0xFF) << 8) + (A[3] & 0xFF),
                ( (B[0] & 0xFF) << 24) + ((B[1] & 0xFF) << 16) + ((B[2] & 0xFF) << 8) + (B[3] & 0xFF)
        };

    }

    private int[] GeneratorOfNumber (int q0[]){
        int Q[] = new int[2];
        int C1 = 0x1010101;
        int C2 = 0x1010104;

        Q[0] = (q0[0] + C1);
        Q[0] &= 0xffffffff; //A + С1 (mod 2^32)

        Q[1] = (q0[1] + C2 - 1);
        Q[1] &= 0xfffffffe;//B + С2 (mod 2^32-1)
        Q[1] += 1;

        return Q;
    }

    private String[] getFiles(String pathIn, int typeWork){
        File folder = new File(pathIn);
        return folder.list((File folder1, String name) -> {
            if(typeWork == 1) return name.endsWith(".mgm");
            return name.endsWith(".sql");
        });
    }

    private String getDate(){
        Locale local = new Locale("ru","RU");
        DateFormat df = DateFormat.getDateInstance (DateFormat.DEFAULT, local);
        return df.format(new Date());
    }
    private String getTime(){
        Locale local = new Locale("ru","RU");
        DateFormat df = DateFormat.getTimeInstance (DateFormat.DEFAULT, local);
        return df.format(new Date());
    }

}
