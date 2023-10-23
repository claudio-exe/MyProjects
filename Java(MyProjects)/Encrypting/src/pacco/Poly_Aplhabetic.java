package pacco;

import java.util.Random;

public class Poly_Aplhabetic {
    static String KEY_STRING = "";
    static String[] KEY_ARRAY;
    static String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";

    public static String genKey() {

        String gen = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        String selected_symbols = "";
        String key = "";
        String[] key_array = new String[63];
        String total_comb = "";
        Random rd = new Random();

        for (int i = 0; i < 8; i++) {
            int r = rd.nextInt(gen.length());
            String tmp = Character.toString(gen.charAt(r));
            selected_symbols += tmp;
            gen = gen.replace(tmp, "");
        }

        for (int i = 0; i < selected_symbols.length(); i++) {
            for (int j = 0; j < selected_symbols.length(); j++) {
                total_comb += Character.toString(selected_symbols.charAt(i)) + Character.toString(selected_symbols.charAt(j));
            }
        }

        for (int i = 0; i < key_array.length; i++) {
            int r = rd.nextInt(total_comb.length());
            if (r % 2 == 0) {
                key_array[i] = Character.toString(total_comb.charAt(r)) + Character.toString(total_comb.charAt((r + 1)));
                total_comb = total_comb.substring(0, r) + total_comb.substring((r + 2), total_comb.length());
            } else {
                key_array[i] = Character.toString(total_comb.charAt(r - 1)) + Character.toString(total_comb.charAt(r));
                total_comb = total_comb.substring(0, r - 1) + total_comb.substring(r + 1, total_comb.length());
            }
        }

        for (int i = 0; i < key_array.length; i++) {
            String tmp = "";
            int r = rd.nextInt(key_array.length);
            tmp = key_array[i];
            key_array[i] = key_array[r];
            key_array[r] = tmp;
        }

        KEY_ARRAY = key_array;

        for (int i = 0; i < key_array.length; i++) {
            key += key_array[i];
        }
        KEY_STRING = key;
        return key;
    }

    public static String encrypt(String s) {
        String enc = "";
        for (int i = 0; i < s.length(); i++) {
            enc += KEY_ARRAY[ALPHA.indexOf(s.charAt(i))];
        }
        return enc;
    }

    public static String decrypt(String s) {
        String dec = "";
        for (int i = 0; i < s.length(); i = i + 2) {
            String c = Character.toString(s.charAt(i)) + Character.toString(s.charAt((i + 1)));
            int j = 0;
            String tmp = "";
            do {
                tmp = KEY_ARRAY[j];
                if (tmp.equals(c)) {
                    dec += ALPHA.charAt(j);
                    break;
                }
                j = (j + 1);
            } while (true);
        }
        return dec;
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

    public static void main(String[] args) {
        genKey();
        String a = "ciao a tutti SONO UNA STRINGA lunga 12345";
        System.out.println("\nChiave: " + KEY_STRING + "\nComposta da: " + distinctSymbol(KEY_STRING).length()
                + " simboli (simboli usati: " + distinctSymbol(KEY_STRING) + ") " +
                "\n\"----------------------------------------------------------------------------------\"");
        System.out.println("Stringa criptata: " + encrypt(a));
        System.out.println("Stringa decriptata: " + decrypt(encrypt(a)));
    }
}