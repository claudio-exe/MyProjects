package pacco;


import java.util.Random;

public class OneTime_Pad {

    public static String genKey(String ss) {
        int len = ss.length();
        Random rd = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = (char) rd.nextInt(0, 26);
            s.append(c);
        }
        return s.toString();
    }

    public static String encOTP(String ss, String key) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            int tmp = (ss.charAt(i) ^ key.charAt(i));
            s.append((char) tmp);
        }
        return s.toString();
    }

    public static String decOTP(String ss, String key) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == ' ') {
                s.append(" ");
            } else {
                int tmp = (ss.charAt(i) ^ key.charAt(i));
                s.append((char) tmp);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {

        String a = "ciao a tutti SONO UNA STRINGA lunga 12345";
        String k = genKey(a);
        System.out.println("______\n"+k+"\n______");

        String en = encOTP(a, k);
        System.out.println(en);
        System.out.println(decOTP(en, k));

    }
}
