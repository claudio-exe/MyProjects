package pacco;


public class ROT_N {

    public static String encN(String s, int shift) {
        StringBuilder tmp= new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') tmp.append(" ");
            else if(c == '\n') tmp.append("\n");
            else if(!Character.isLetter(c)) tmp.append(c);
            else {
                char ctmp = ' ';
                if(Character.isUpperCase(c)){
                    ctmp = c;
                    c = Character.toLowerCase(c);
                }
                int ris = (c + shift % 26) % 123;
                if (ris < 97 ) ris += 97;
                if(Character.isUpperCase(ctmp)){
                    ctmp = (char)ris;
                    ctmp = Character.toUpperCase(ctmp);
                }else{
                    ctmp = (char)ris;
                }
                tmp.append(ctmp);
            }
        }
        return tmp.toString();
    }

    public static String decN(String s, int shift){
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') tmp.append(" ");
            else if(c == '\n') tmp.append("\n");
            else if(!Character.isLetter(c)) tmp.append(c);
            else {
                int ris = 0;
                char ctmp = ' ';
                if(Character.isUpperCase(c)){
                    ctmp = c;
                    c = Character.toLowerCase(c);
                }
                if((c - (shift % 26) % 123) < 97){
                    ris = (c + 26) - (shift % 26);
                }else{
                    ris = (c - (shift % 26)) % 123;
                    if(ris < 97) ris += 97;
                }
                if(Character.isUpperCase(ctmp)){
                    ctmp = (char)ris;
                    ctmp = Character.toUpperCase(ctmp);
                }else{
                    ctmp = (char)ris;
                }
                tmp.append(ctmp);
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) {

        //"abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWYXZ-0123456789";
        //"abcdefghijklmnopqrstuvwxyz";

        String s1 = "enivjneifvjnfv";
        System.out.println(s1);
        String s2 = encN(s1,40);
        System.out.println(s2);
        System.out.println(decN(s2, 40));
    }
}
