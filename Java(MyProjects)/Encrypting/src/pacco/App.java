package pacco;


public class App {
    
    public static void main(String[] args) {
    
        String s = "abcdef";
        int i = 4;
        s = s.substring(0,i) + s.substring((i + 2),s.length());
        System.out.println(s);
        
    }

}
