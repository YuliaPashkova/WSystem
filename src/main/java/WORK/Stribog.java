package WORK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Rob on 02.05.2017.
 * Реализует хеширование по алгоритму "Стрибог"
 */
public class Stribog {
    private static BigInteger A[] = new BigInteger[64];
    private static BigInteger Sbox[] = new BigInteger[256];
    private static BigInteger Tau [] = {
            BigInteger.valueOf(0),BigInteger.valueOf(8),BigInteger.valueOf(16),BigInteger.valueOf(24),BigInteger.valueOf(32),BigInteger.valueOf(40),BigInteger.valueOf(48),BigInteger.valueOf(56),
            BigInteger.valueOf(1),BigInteger.valueOf(9),BigInteger.valueOf(17),BigInteger.valueOf(25),BigInteger.valueOf(33),BigInteger.valueOf(41),BigInteger.valueOf(49),BigInteger.valueOf(57),
            BigInteger.valueOf(2),BigInteger.valueOf(10),BigInteger.valueOf(18),BigInteger.valueOf(26),BigInteger.valueOf(34),BigInteger.valueOf(42),BigInteger.valueOf(50),BigInteger.valueOf(58),
            BigInteger.valueOf(3),BigInteger.valueOf(11),BigInteger.valueOf(19),BigInteger.valueOf(27),BigInteger.valueOf(35),BigInteger.valueOf(43),BigInteger.valueOf(51),BigInteger.valueOf(59),
            BigInteger.valueOf(4),BigInteger.valueOf(12),BigInteger.valueOf(20),BigInteger.valueOf(28),BigInteger.valueOf(36),BigInteger.valueOf(44),BigInteger.valueOf(52),BigInteger.valueOf(60),
            BigInteger.valueOf(5),BigInteger.valueOf(13),BigInteger.valueOf(21),BigInteger.valueOf(29),BigInteger.valueOf(37),BigInteger.valueOf(45),BigInteger.valueOf(53),BigInteger.valueOf(61),
            BigInteger.valueOf(6),BigInteger.valueOf(14),BigInteger.valueOf(22),BigInteger.valueOf(30),BigInteger.valueOf(38),BigInteger.valueOf(46),BigInteger.valueOf(54),BigInteger.valueOf(62),
            BigInteger.valueOf(7),BigInteger.valueOf(15),BigInteger.valueOf(23),BigInteger.valueOf(31),BigInteger.valueOf(39),BigInteger.valueOf(47),BigInteger.valueOf(55),BigInteger.valueOf(63)
    };
    private static BigInteger C[][] = new BigInteger[12][64];
    private BigInteger[] iv =new BigInteger[64];
    private BigInteger[] N =new BigInteger[64];
    private BigInteger[] Sigma = new BigInteger[64];
    private int outLen = 0;

    public Stribog(int outputLenght) {
        if (outputLenght == 512) {
            for (int i = 0; i < 64; i++) {
                N[i] = BigInteger.ZERO;
                Sigma[i] = BigInteger.ZERO;
                iv[i] = BigInteger.ZERO;
            }
            outLen = 512;
        }
        else if (outputLenght == 256) {
            for (int i = 0; i < 64; i++) {
                N[i] = BigInteger.ZERO;
                Sigma[i] = BigInteger.ZERO;
                iv[i] = BigInteger.ONE;
            }
            outLen = 256;
        }
    }

    private void initA() throws IOException {
        byte initial[] = new byte[8];
        try (BufferedReader in = new BufferedReader(new FileReader("src\\main\\resources\\matrix_stribog\\A.txt"))) {//В цикле построчно считываем файл
            String s;
            int k = 0; //счетчик для А
            while ((s = in.readLine()) != null) {
                for (int i = 0, j = 0; i < 16; j++) {
                    initial[j] = (byte) (Integer.parseInt(s.substring(i, i += 2), 16));
                }
                A[k++] = new BigInteger(1, initial);
            }
        }
    }
    private void initSbox() throws IOException {
        byte initial[] = new byte[]{(byte) 0x00};
        try (BufferedReader in = new BufferedReader(new FileReader("src\\main\\resources\\matrix_stribog\\Sbox.txt"))) {//В цикле построчно считываем файл
            String s;
            int k = 0; //счетчик для Sbox
            while ((s = in.readLine()) != null) {
                initial[0] = (byte) (Integer.parseInt(s, 16));
                Sbox[k++] = new BigInteger(1, initial);
            }
        }

    }
    private void initC() throws IOException {
        byte initial[] = new byte[]{(byte) 0x00};
        String temp[]; //строку по пробелу разделяем и сюда пишем(по байтам в каждую ячейку)
        try (BufferedReader in = new BufferedReader(new FileReader("src\\main\\resources\\matrix_stribog\\C.txt"))) {//В цикле построчно считываем файл
            String s;
            int j = 0; //счетчик для строк (12)
            while ((s = in.readLine()) != null) {
                temp = s.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    initial[0] = (byte) (Integer.parseInt(temp[i], 16));
                    C[j][i] = new BigInteger(1, initial);
                }
                j++; //следующая 64-значная строка
            }
        }
    }
    private BigInteger[] AddModulo512(BigInteger[] a, BigInteger[] b) {
        BigInteger[] temp = initBigInteger0(64);
        int i;
        BigInteger t = new BigInteger(new byte[4]);
        BigInteger[] tempA = initBigInteger0(64);
        BigInteger[] tempB = initBigInteger0(64);

        BigInteger ff = new BigInteger(1, new byte[]{(byte)0xFF});
//источник, с какого индекса копировать, приемник, с какого индекста вставлять, кол-во элементов
        System.arraycopy(a, 0, tempA, 64 - a.length, a.length);
        System.arraycopy(b, 0, tempB, 64 - b.length, b.length);
        for (i = 63; i >= 0; i--) {
            t = t.shiftRight(8);
            t = tempA[i].add(tempB[i]).add(t);
            temp[i] = t.and(ff);
        }
        return temp;
    }

    private BigInteger[] AddXor512(BigInteger[] a, BigInteger[] b) {
        BigInteger[] c = initBigInteger0(64);
        for (int i = 0; i < 64; i++)
            c[i] = a[i].xor(b[i]);
        return c;
    }

    private BigInteger[] S(BigInteger[] state) {
        BigInteger[] result = initBigInteger0(64);
        for (int i = 0; i < 64; i++)
            result[i] = Sbox[state[i].intValue()];
        return result;
    }

    private BigInteger[] P(BigInteger[] state) {
        BigInteger[] result = initBigInteger0(64);
        for (int i = 0; i < 64; i++)
            result[i] = state[Tau[i].intValue()];
        return result;
    }

    private BigInteger[] L(BigInteger[] state) {
        int cnt = -1; //счетчик для записи частей результата в result
        //за каждую итерацию увеличивается на 8, так как
        //за итерацию вычисляется 8 байт в пишется в result
        BigInteger[] result = initBigInteger0(64);

        for (int i = 0; i < 8; i++) {
            BigInteger t = new BigInteger(1, new byte[8]);
            BigInteger tempArray[] = initBigInteger0(8);

            System.arraycopy(state, i * 8, tempArray, 0, 8);

            for(int h = 0; h < tempArray.length / 2; h++) { //temparray.reverse()
                BigInteger temp = tempArray[h];
                tempArray[h] = tempArray[tempArray.length - h - 1];
                tempArray[tempArray.length - h - 1] = temp;
            }

            boolean[] tempBits = new boolean[64];
            //в 2CC
            for(int k = 0, s = -1; k < 8; k++){ //по элементам temparray
                String str = Integer.toBinaryString(tempArray[k].intValue()); //7 -> 111
                int cc = str.length(); //кол-во символов в двоичном представлении, нужно восемь
                for(int p = 0; p < 8 - cc; p++)//добавляем ведущие нули к 111 -> 0000 0111
                    tempBits[++s] = false;
                for(int p = 0; p < cc; p++) //записываем остальную часть числа из str
                    tempBits[++s] = str.charAt(p) != '0';
            }
            //реверсируем байты в tempBits, т. е. первые 8 бит станут последними
            tempBits = reverseByte(tempBits);
            //работа с битами из tempBits
            for (int j = 0; j < 64; j++){
                if (tempBits[j]) //==true
                    t = t.xor(A[j]);
            }
            //из t выделяем по очереди 8 байт и пишем в rez
            //пишшем сразу с reverse                                                            0xFF00000000000000L
            result[++cnt] = t.and(new BigInteger("18374686479671624480")).shiftRight(56);//0xFF00000000000000L)>>56)
            result[++cnt] = t.and(new BigInteger("71776119061217280")).shiftRight(48);//  0xFF000000000000L)>>48);
            result[++cnt]= t.and(new BigInteger("280375465082880")).shiftRight(40);//0xFF0000000000L)>>40);
            result[++cnt]= t.and(new BigInteger("1095216660480")).shiftRight(32);//      0xFF00000000L)>>32);
            result[++cnt]= t.and(new BigInteger("4278190080")).shiftRight(24);//        0xFF000000)>>24);
            result[++cnt]= t.and(new BigInteger("16711680")).shiftRight(16);//          0xFF0000)>>16);
            result[++cnt]= t.and(new BigInteger("65280")).shiftRight(8);//            0xFF00)>>8);
            result[++cnt]= t.and(new BigInteger("255"));//             0xFF);
        }
        return result;
    }

    private BigInteger[] KeySchedule(BigInteger[] K, int i) {
        K=AddXor512(K, C[i]);
        K = S(K);
        K = P(K);
        K = L(K);
        return K;
    }

    private BigInteger[] E(BigInteger[] K, BigInteger[] m) {
        BigInteger[] state = AddXor512(K, m);
        for (int i = 0; i < 12; i++) {
            state=S(state);
            state = P(state);
            state = L(state);
            K=KeySchedule(K, i);
            state = AddXor512(state, K);
        }
        return state;
    }

    private BigInteger[] G_n(BigInteger[] N, BigInteger[] h, BigInteger[] m) {
        BigInteger[] K = AddXor512(h, N);
        K=S(K);
        K=P(K);
        K=L(K);
        BigInteger[] t= E(K, m);
        t=AddXor512(t, h);
        return AddXor512(t, m);
    }

    private BigInteger[] Work(BigInteger[] message) throws IOException {
        initA();
        initSbox();
        initC();

        BigInteger[] paddedMes = initBigInteger0(64);
        int len = message.length * 8;
        BigInteger[] h = initBigInteger0(64);
        System.arraycopy(iv, 0, h, 0,64);
        BigInteger[] N_0 = initBigInteger0(64);

        if (outLen == 512){
            for (int i = 0; i < 64; i++) {
                N[i] = BigInteger.ZERO;
                Sigma[i] = BigInteger.ZERO;
                iv[i] = BigInteger.ZERO;
            }
        }
        else if (outLen == 256) {
            for (int i = 0; i < 64; i++) {
                N[i] = BigInteger.ZERO;
                Sigma[i] = BigInteger.ZERO;
                iv[i] = BigInteger.ONE;
            }
        }
        BigInteger[] N_512 = new BigInteger[4]; // 0 0 2 0
        byte input[] = {(byte)0, (byte)0, (byte)2, (byte)0};
        for(int w = 0; w < 4; w++) {
            N_512[w] = new BigInteger(1, new byte[]{(byte) 0x00});
            N_512[w] = BigInteger.valueOf(input[w]);
        }

        int inc = 0;
        while (len >= 512) {
            inc++;
            BigInteger[] tempMes = initBigInteger0(64);
            System.arraycopy(message, message.length - inc*64, tempMes, 0, 64);
            h=G_n(N, h, tempMes);
            N = AddModulo512(N, N_512);
            Sigma=AddModulo512(Sigma, tempMes);
            len -= 512;
        }

        BigInteger[] message1 = initBigInteger0(message.length - inc * 64);
        System.arraycopy(message, 0, message1, 0, message.length - inc * 64);

        if (message1.length < 64) {
            for (int i = 0; i < (64 - message1.length - 1); i++)
                paddedMes[i] = BigInteger.ZERO;

            paddedMes[64 - message1.length - 1] = BigInteger.ONE;
            System.arraycopy(message1, 0, paddedMes, 64 - message1.length, message1.length);
        }
        h=G_n(N, h, paddedMes);

        int len_mes = message1.length * 8;
        //   byte[] MesLen = BitConverter.GetBytes(message1.Length * 8);
        BigInteger MesLen[] = initBigInteger0(4);

        MesLen[3] = BigInteger.valueOf(len_mes & 0xFF);
        MesLen[2] = BigInteger.valueOf((len_mes & 0xFF00)>>8);
        MesLen[1] = BigInteger.valueOf((len_mes & 0xFF0000)>>16);
        MesLen[0] = BigInteger.valueOf((len_mes & 0xFF000000L)>>24);

        N = AddModulo512(N, MesLen);
        Sigma = AddModulo512(Sigma, paddedMes);
        h = G_n(N_0, h, N);
        h = G_n(N_0, h, Sigma);
        if (outLen == 512)
            return h;
        else {
            BigInteger[] h256 = initBigInteger0(32);
            System.arraycopy(h, 0, h256, 0, 32);
            return h256;
        }
    }

    private boolean[] reverseByte(boolean bi[]){
        boolean res[] = new boolean[bi.length];
        int start[] = new int[]{56, 48, 40, 32, 24, 16, 8, 0};
        int end[] = new int[] {63, 55, 47, 39, 31, 23, 15, 7};
        int k = 0;
        for(int i = 0; i < start.length; i++){
            for(int j = start[i]; j <= end[i]; j++){
                res[j] = bi[k++];
            }
        }
        return  res;
    }

    private BigInteger[] initBigInteger0(int size){//построение беззнакового числа BigInteger
        BigInteger res[] = new BigInteger[size];
        for(int i = 0; i < res.length; i++)
            res[i] = new BigInteger(1, new byte[]{(byte) 0x00});
        return res;
    }

    /**
     * Метод связи
     *
     * Преобразовывает String-пароль к виду массива unsigned byte []
     * Вызывает work(), который формирует хэш
     *
     * @param m - строка, для которой нужен хэш
     * @return хэш строки m
     */
    public  String getHash(String m) throws IOException {
        byte initial[] = m.getBytes(); //строку в байты
        BigInteger[] message = new BigInteger[initial.length];
        //initil = сообщение, записываем по байтно его в message
        for(int i = 0; i < message.length; i++)
            message[i] = new BigInteger(1, new byte[]{initial[i]});
        //основой метод
        BigInteger[] rez = Work(message);
        String result = "";

        for (BigInteger aRez : rez)
            result += Integer.toHexString(aRez.intValue());
        return result;
    }
}

