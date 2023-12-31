package pacco;

import java.util.Random;

public class Mono_Alphabetic {
    static String k = "";

    public static String genKey() {
        final String alpha = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String reg = alpha;
        String key = "";
        Random rd = new Random();

        do {
            int tmp = rd.nextInt(0, reg.length());
            key += reg.charAt(tmp);
            reg = reg.replace(Character.toString(reg.charAt(tmp)), "");
        } while (reg.length() != 0);
        k = key;
        return key;
    }

    public static String encrypt(String s) {
        StringBuilder enc = new StringBuilder();
        final String alpha = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = k;

        for (int i = 0; i < s.length(); i++) {
            int pos = alpha.indexOf(s.charAt(i));
            char ch = key.charAt(pos);
            enc.append(ch);
        }

        return enc.toString();
    }

    public static String decrypt(String s) {
        StringBuilder dec = new StringBuilder();
        final String alpha = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = k;

        for (int i = 0; i < s.length(); i++) {
            int pos = key.indexOf(s.charAt(i));
            char ch = alpha.charAt(pos);
            dec.append(ch);
        }

        return dec.toString();
    }

    public static void main(String[] args) {

        String s = "oll ai uont for crismas is iuuuuu";
        System.out.println("String: " + s);
        genKey();
        String encr = encrypt(s);
        System.out.println("Encrypted: " + encr);
        System.out.println("Decrypted: " + decrypt(encr));

    }
}