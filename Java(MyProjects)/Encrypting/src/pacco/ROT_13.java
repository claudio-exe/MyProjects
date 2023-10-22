package pacco;


public class ROT_13 {

    public static String enc(String s) {
        StringBuilder tmp= new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' ') tmp.append(" ");
            else {
                int ris = (c + 13) % 123;
                if (ris < 97) ris += 97;
                tmp.append((char) ris);
            }
        }

        return tmp.toString();
    }
    public static String dec(String s) {
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') tmp.append(" ");
            else {
                int ris = (c + 13) % 123;
                if ((ris < 97)) ris += 97;
                tmp.append((char) ris);
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) {
        String s1 = "akuna matata ragazzi e benvenuti dal vostro cicciogaymerd ottantanove";
        System.out.println(s1);
        String s2 = enc(s1);
        System.out.println(s2);
        System.out.println(dec(s2));
    }
}
