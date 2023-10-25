package pacco;

import java.util.ArrayList;
import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {

        String s1 = "abcdef";
        int i = 4;
        s1 = s1.substring(0, i) + s1.substring((i + 2), s1.length());
        System.out.println(s1);
        String cazzo = "a\nb\"\\#";
        System.out.println(cazzo.indexOf("\\"));
        System.out.println(cazzo.contains("\\"));
        Scanner sc = new Scanner(System.in);
        boolean b = false;
        String str = "";
        do {
            System.out.println("Scanner: ");
            str = sc.nextLine();
            b = str.isEmpty() || str.isBlank();
            if (b){
                System.out.println("riprova.");
            }
        } while (b);
        System.out.println(str);
        sc.close();
    }

}
