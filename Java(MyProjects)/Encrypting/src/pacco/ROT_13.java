package pacco;

public class ROT_13 {

    public static String enc(String s) {
        StringBuilder enc_s = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                enc_s.append(" ");
            else {
                int res = (c + 13) % 123;
                if (res < 97)
                    res += 97;
                enc_s.append((char) res);
            }
        }

        return enc_s.toString();
    }

    public static String dec(String s) {
        StringBuilder dec_s = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                dec_s.append(" ");
            else {
                int res = (c + 13) % 123;
                if ((res < 97))
                    res += 97;
                dec_s.append((char) res);
            }
        }
        return dec_s.toString();
    }

    public static void main(String[] args) {
        String s = "akuna matata ragazzi e benvenuti dal vostro cicciogaymerd ottantanove";
        System.out.println(s);
        String encrypted_s = enc(s);
        System.out.println(encrypted_s);
        System.out.println(dec(encrypted_s));
    }
}
