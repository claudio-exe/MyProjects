package pacco;

import java.util.Random;

public class Poly_Aplhabetic {
    static String k = "";
    static String[] ka;
    static String alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";

    public static String genKey() {

        String gen = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        String c = "";
        String key = "";
        String[] cc = new String[63];
        String kt = "";
        Random rd = new Random();

        for (int i = 0; i < 8; i++) {
            int r = rd.nextInt(gen.length());
            String tmp = Character.toString(gen.charAt(r));
            c += tmp;
            gen = gen.replace(tmp, "");
        }

        for (int i = 0; i < c.length(); i++) {
            for (int j = 0; j < c.length(); j++) {
                kt += Character.toString(c.charAt(i)) + Character.toString(c.charAt(j));
            }
        }

        for (int i = 0; i < cc.length; i++) {
            int r = rd.nextInt(kt.length());
            if (r % 2 == 0) {
                cc[i] = Character.toString(kt.charAt(r)) + Character.toString(kt.charAt((r + 1) % kt.length()));
                kt = kt.substring(0, r) + kt.substring((r + 2), kt.length());
            } else {
                cc[i] = Character.toString(kt.charAt(r - 1)) + Character.toString(kt.charAt(r));
                kt = kt.substring(0, r - 1) + kt.substring(r + 1, kt.length());
            }
        }

        for (int i = 0; i < cc.length; i++) {
            String tmp = "";
            int r = rd.nextInt(cc.length);
            tmp = cc[i];
            cc[i] = cc[r];
            cc[r] = tmp;
        }

        ka = cc;

        for (int i = 0; i < cc.length; i++) {
            key += cc[i];
        }
        k = key;
        return key;
    }

    public static String encrypt(String s) {
        String enc = "";
        for (int i = 0; i < s.length(); i++) {
            enc += ka[alfa.indexOf(s.charAt(i))];
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
                tmp = ka[j];
                if (tmp.equals(c)) {
                    dec += alfa.charAt(j);
                    break;
                }
                j = (j + 1) % ka.length;
            } while (true);
        }
        return dec;
    }

    public static void main(String[] args) {
        genKey();
        String a = "ciao a tutti SONO UNA STRINGA lunga 12345";
        System.out.println("chiave: " + k + "\n");
        System.out.println(encrypt(a));
        System.out.println(decrypt(encrypt(a)));
    }
}