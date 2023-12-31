package pacco;

import java.util.*;

public class nonloso {

    static String k = "";
    
    public static String genKey(){
        final String alfa = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String reg = alfa;
        String key = "";
        Random rd = new Random();
        
        do{
            int tmp = rd.nextInt(0,reg.length());
            key += reg.charAt(tmp);
            reg = reg.replace(Character.toString(reg.charAt(tmp)),"");
        }while(reg.length() != 0);
        k = key;
        return key;
    }

    public static String encrypt(String s){
        StringBuilder enc = new StringBuilder();
        final String alfa = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = k;

        for(int i = 0; i < s.length();i++){
            int pos = alfa.indexOf(s.charAt(i));
            char ch = key.charAt(pos);
            enc.append(ch);
        }

        return enc.toString();
    }

    public static String decrypt(String s){
        StringBuilder enc = new StringBuilder();
        final String alfa = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = k;

        for(int i = 0; i < s.length();i++){
            int pos = key.indexOf(s.charAt(i));
            char ch = alfa.charAt(pos);
            enc.append(ch);
        }

        return enc.toString();
    }

    public static void main(String[] args) {
    
        String s = "i topi non avevano nipoti";
        System.out.println("String: "+s);
        genKey();
        String encr = encrypt(s);
        System.out.println("Encrypted: "+encr);
        System.out.println("Decrypted: "+decrypt(encr));
        
    }
}