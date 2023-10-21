package pacco;

import java.util.ArrayList;

public class App {
    
    public static void main(String[] args) {
    
        String s1 = "abcdef";
        int i = 4;
        s1 = s1.substring(0,i) + s1.substring((i + 2),s1.length());
        System.out.println(s1);
        String cazzo = "a\nb\"#";
        System.out.println(cazzo.indexOf("\\"));
        System.out.println(cazzo.contains("\\"));

        for(int j = 0; j < 300; j++){
            char tmp = (char)j;
            System.out.println("char: " + j + " = " + tmp);
        }
    }

}
