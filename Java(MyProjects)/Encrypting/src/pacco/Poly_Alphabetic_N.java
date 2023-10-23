package pacco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Poly_Alphabetic_N {
    static String KEY_STRING = "";
    static List<String> KEY_LIST = new ArrayList<>();
    static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789òàèéùì()[]{}@#§€;:,.-_?!|^£$%&/='\\<>\"°*+\n";

    private static String genKey(int symbol, int symbol_number) {
        String gen = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        if (symbol > gen.length()) {
            symbol = gen.length();
        } else if ((long) Math.pow(symbol, symbol_number) < ALPHA.length()) {
            do {
                symbol_number++;
            } while ((long) Math.pow(symbol, symbol_number) < ALPHA.length());
        }
        String key = "";
        String selected_symbols = "";
        List<String> couples = new ArrayList<>();
        Random rd = new Random();

        for (int i = 0; i < symbol; i++) {
            int r = rd.nextInt(gen.length());
            String tmp = Character.toString(gen.charAt(r));
            selected_symbols += tmp;
            gen = gen.replace(tmp, "");
        }

        couples = generator(selected_symbols, symbol_number);

        for (int i = 0; i < ALPHA.length(); i++) {
            int r = rd.nextInt(couples.size());
            KEY_LIST.add(couples.get(r));
            couples.remove(r);
        }

        for (int i = 0; i < KEY_LIST.size(); i++) {
            key += KEY_LIST.get(i);
        }
        KEY_STRING = key;
        return key;
    }

    private static String encrypt(String s) {
        String enc = "";
        for (int i = 0; i < s.length(); i++) {
            enc += KEY_LIST.get(ALPHA.indexOf(s.charAt(i)));
        }
        return enc;
    }

    private static String decrypt(String s) {
        String dec = "";
        int symb = KEY_LIST.get(0).length();
        for (int i = 0; i < s.length(); i = i + symb) {
            String sub_s = "";
            sub_s = s.substring(i, i + symb);
            int j = 0;
            String tmp = "";
            do {
                tmp = KEY_LIST.get(j);
                if (tmp.equals(sub_s)) {
                    dec += ALPHA.charAt(j);
                    break;
                }
                j = (j + 1);
            } while (true);
        }
        return dec;
    }

    private static List<String> generator(String str, int coupleLength) {
        long count = (long) Math.pow(str.length(), coupleLength);
        List<String> couples = new ArrayList<>();
        if (count < 1000000) {
            couples = generateCouples(str, coupleLength);
        } else {
            couples = casualCouples(str, coupleLength);
        }
        return couples;

    }

    public static List<String> generateCouples(String str, int coupleLength) {
        List<String> couples = new ArrayList<>();
        long n = (int) Math.pow(str.length(), coupleLength);
        int[] indexes = new int[coupleLength];

        for (int i = 0; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indexes[j]));
            }
            couples.add(tmp.toString());

            for (int j = coupleLength - 1; j >= 0; j--) {
                indexes[j]++;
                if (indexes[j] < str.length()) {
                    break;
                }
                indexes[j] = 0;
            }
        }
        return couples;
    }

    public static List<String> casualCouples(String str, int coupleLength) {
        List<String> couples = new ArrayList<>();
        int[] indexes = new int[coupleLength];
        Random rd = new Random();
        do {
            StringBuilder tmp = new StringBuilder();
            for (int z = coupleLength - 1; z >= 0; z--) {
                indexes[z] = rd.nextInt(str.length());
            }
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indexes[j]));
            }
            if (!couples.contains(tmp.toString())) {
                couples.add(tmp.toString());
            }
        } while (couples.size() < 1000);
        return couples;
    }

    public static int symbolCount(String s) {
        int j = 0;
        do {
            String tmp = s.replace(Character.toString(s.charAt(0)), "");
            s = tmp;
            j++;
        } while (s.length() > 0);
        return j;
    }

    public static String distinctSymbol(String s) {
        StringBuilder symbol = new StringBuilder();
        do {
            symbol.append(s.charAt(0));
            String tmp = s.replace(Character.toString(s.charAt(0)), "");
            s = tmp;
        } while (s.length() > 0);
        return symbol.toString();
    }

    private static List<String> getKeyList(String s, int shift) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i = i + shift) {
            String tmp = s.substring(i, i + shift);
            list.add(tmp);
        }
        return list;
    }

    private static void printAlphabet() {
        List<String> key_list = getKeyList(KEY_STRING, KEY_LIST.get(0).length());
        for (int i = 0; i < key_list.size(); i++) {
            if (Character.toString(ALPHA.charAt(i)).equals("\n")) {
                System.out.println("\\n: " + key_list.get(i));
            } else {
                System.out.println(ALPHA.charAt(i) + ": " + key_list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        genKey(63, 7);
        String a = "ciao a tutti SONO UNA STRINGA lunga 12345";
        System.out.println("\nChiave: " + KEY_STRING + "\nComposta da: " + distinctSymbol(KEY_STRING).length()
                + " simboli (simboli usati: " + distinctSymbol(KEY_STRING) + ") " +
                "\n\"----------------------------------------------------------------------------------\"");
        printAlphabet();
        System.out.println("\"----------------------------------------------------------------------------------\"");
        String ea = encrypt(a);
        System.out.println("Stringa criptata: " + ea);
        System.out.println("Stringa decriptata: " + decrypt(ea));

    }
}