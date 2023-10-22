package pacco;


public class Cesare {
    public String dec(String s) {
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') tmp.append(" ");
            else {
                c = (char) ((c-3)%123);
                tmp.append(c);
            }
        }
        return tmp.toString().toLowerCase();
    }
    public String enc(String s) {
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') tmp.append(" ");
            else {
                c = (char) ((c+3)%123);
                tmp.append(c);
            }
        }
        return tmp.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Cesare c = new Cesare();
        String s = "ciao a tutti";
        String enc = c.enc(s);
        String dec = c.dec(enc);
        System.out.println(enc);
        System.out.println(dec);
    }
}
