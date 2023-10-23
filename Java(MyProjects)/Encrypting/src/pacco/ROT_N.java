package pacco;

public class ROT_N {

    public static String encN(String s, int shift) {
        StringBuilder enc_s = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ')
                enc_s.append(" ");
            else if (current == '\n')
                enc_s.append("\n");
            else if (!Character.isLetter(current))
                enc_s.append(current);
            else {
                char c_upperCase = ' ';
                if (Character.isUpperCase(current)) {
                    c_upperCase = current;
                    current = Character.toLowerCase(current);
                }
                int res = (current + shift % 26) % 123;
                if (res < 97)
                    res += 97;
                if (Character.isUpperCase(c_upperCase)) {
                    c_upperCase = (char) res;
                    c_upperCase = Character.toUpperCase(c_upperCase);
                } else {
                    c_upperCase = (char) res;
                }
                enc_s.append(c_upperCase);
            }
        }
        return enc_s.toString();
    }

    public static String decN(String s, int shift) {
        StringBuilder dec_s = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ')
                dec_s.append(" ");
            else if (current == '\n')
                dec_s.append("\n");
            else if (!Character.isLetter(current))
                dec_s.append(current);
            else {
                int res = 0;
                char c_upperCase = ' ';
                if (Character.isUpperCase(current)) {
                    c_upperCase = current;
                    current = Character.toLowerCase(current);
                }
                if ((current - (shift % 26) % 123) < 97) {
                    res = (current + 26) - (shift % 26);
                } else {
                    res = (current - (shift % 26)) % 123;
                    if (res < 97)
                        res += 97;
                }
                if (Character.isUpperCase(c_upperCase)) {
                    c_upperCase = (char) res;
                    c_upperCase = Character.toUpperCase(c_upperCase);
                } else {
                    c_upperCase = (char) res;
                }
                dec_s.append(c_upperCase);
            }
        }
        return dec_s.toString();
    }

    public static void main(String[] args) {

        // "abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWYXZ-0123456789";
        // "abcdefghijklmnopqrstuvwxyz";

        String s = "ciao a tutti SONO UNA STRINGA lunga 12345";
        System.out.println(s);
        String encrpted_s = encN(s, 40);
        System.out.println(encrpted_s);
        System.out.println(decN(encrpted_s, 40));
    }
}
