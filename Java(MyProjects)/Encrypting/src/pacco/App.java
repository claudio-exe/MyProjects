package pacco;


public class App {
    
    public static void main(String[] args) {
    
        String s = "abcde";
        s = s.substring(0,2) + s.substring(3,s.length());
        System.out.println(s);
        
    }

}
