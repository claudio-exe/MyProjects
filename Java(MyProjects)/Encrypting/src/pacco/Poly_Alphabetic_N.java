package pacco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Poly_Alphabetic_N {
    static String k = "";
    static List<String> ka = new ArrayList<>();
    static String alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";

    public static String genKey(int symbol, int symbol_number) {
        if(symbol > 63){
            symbol = 63;
        }
        String gen = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        String key = "";
        String c = "";
        List<String> couples = new ArrayList<>();
        Random rd = new Random();

        for (int i = 0; i < symbol; i++) {
            int r = rd.nextInt(gen.length());
            String tmp = Character.toString(gen.charAt(r));
            c += tmp;
            gen = gen.replace(tmp, "");
        }

        couples = generator(c, symbol_number);

        for (int i = 0; i < 63; i++) {
            int r = rd.nextInt(couples.size());
            ka.add(couples.get(r));
            couples.remove(r);
        }

        for (int i = 0; i < ka.size(); i++) {
            key += ka.get(i);
        }
        k = key;
        return key;
    }

    public static String encrypt(String s) {
        String enc = "";
        for (int i = 0; i < s.length(); i++) {
            enc += ka.get(alfa.indexOf(s.charAt(i)));
        }
        return enc;
    }

    public static String decrypt(String s) {
        String dec = "";
        int symb = ka.get(0).length();
        for (int i = 0; i < s.length(); i = i + symb) {
            String c = "";
            c = s.substring(i, i + symb);
            int j = 0;
            String tmp = "";
            do {
                tmp = ka.get(j);
                if (tmp.equals(c)) {
                    dec += alfa.charAt(j);
                    break;
                }
                j = (j + 1);
            } while (true);
        }
        return dec;
    }

    public static List<String> generator(String str, int coupleLength){
        long count = (long)Math.pow(str.length(),coupleLength);
        List<String> coppie = new ArrayList<>();
        if(count < 1000000){
            coppie = generateCouples(str, coupleLength);
        }else{
            coppie = casualCouples(str, coupleLength);
        }
        return coppie;

    }

    public static List<String> generateCouples(String str, int coupleLength) {
        List<String> coppie = new ArrayList<>();
        long n = (int) Math.pow(str.length(), coupleLength);
        int[] indici = new int[coupleLength];

        for (int i = 0; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indici[j]));
            }
            coppie.add(tmp.toString());

            for (int j = coupleLength - 1; j >= 0; j--) {
                indici[j]++;
                if (indici[j] < str.length()) {
                    break;
                }
                indici[j] = 0;
            }
        }
        return coppie;
    }

    public static List<String> casualCouples(String str, int coupleLength) {
        List<String> coppie = new ArrayList<>();
        Set<String> couples = new HashSet<>();
        int[] indici = new int[coupleLength];
        Random rd = new Random();
        do {
            StringBuilder tmp = new StringBuilder();
            for (int z = coupleLength - 1; z >= 0; z--) {
                indici[z] = rd.nextInt(str.length());
            }
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indici[j]));
            }
            if (!couples.contains(tmp.toString())) {
                couples.add(tmp.toString());
            }
        } while (couples.size() < 1000);
        coppie.addAll(couples);
        return coppie;
    }

    public static int symbolCount(String s){
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        int j = 0;
        int count = 0;
        do{
            String tmp = s.replace(Character.toString(alfabeto.charAt(j)),"");
            if(!tmp.equals(s)){
                count++;
            }
            s = tmp;
            j++;
        }while(s.length() > 0);
        return count;
    }

    public static List<String> getKeyList(String s, int shift){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i = i + shift){
            String tmp = s.substring(i, i + shift);
            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        genKey(63,25);
        List<String> u = getKeyList(k, ka.get(0).length());
        String a = "ciao a tutti SONO UNA STRINGA lunga 12345";
        System.out.println("Chiave: " + k + "\nComposta da: "+ symbolCount(k) + " simboli" +
        "\n\"----------------------------------------------------------------------\"");
        System.out.println("Stringa criptata: " + encrypt(a));
        System.out.println("Stringa decriptata: " + decrypt(encrypt(a)));
        for(int i = 0; i < u.size(); i++){
            System.out.println(alfa.charAt(i) + ": " + u.get(i));
        }
    }
}