package pacco;

import java.util.Random;

public class Poly_Aplhabetic {
    static String k = "";

    public static String genKey() {
        String c = "abcdef";
        String cc = "";
        for (int i = 0; i < c.length(); i++) {
            for (int j = i; j < c.length(); j++) {
                cc += Character.toString(c.charAt(i)) + Character.toString(c.charAt(j));
            }
        }
        System.out.println(cc);
        final String alfa = cc;
        String reg = alfa;
        String key = "";
        Random rd = new Random();

        do {
            int tmp = rd.nextInt(reg.length());
            String stmp = "";
            if(tmp % 2 == 0){
                stmp = Character.toString(reg.charAt(tmp)) + Character.toString(reg.charAt((tmp + 1) % reg.length()));
                key += stmp;
            }else{
                stmp = Character.toString(reg.charAt(tmp - 1)) + Character.toString(reg.charAt(tmp));
                key += stmp;
            }
            reg = reg.replace(stmp, "");
        } while (reg.length() != 0);
        k = key;
        return key;
    }

    public static void main(String[] args) {
        genKey();
        System.out.println(k);
        // aaabacadaeafbabbbcbdbebfcacbcccdcecfdadbdcdddedfeaebecedeeeffafbfcfdfeff
    }
}