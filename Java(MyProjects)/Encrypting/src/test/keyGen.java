package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class keyGen {

    public static void main(String[] args) {
        List<String> k = keyGenerator(15, 10);
        printList(k);
    }
    
    public static List<String> keyGenerator(int keyLength, int keysNum) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        List<String> keys = new ArrayList<>();
        int[] index = new int[keyLength];
        Random rd = new Random();
        do {
            StringBuilder tmp = new StringBuilder();
            for (int z = keyLength - 1; z >= 0; z--) {
                index[z] = rd.nextInt(str.length());
            }
            for (int j = 0; j < keyLength; j++) {
                tmp.append(str.charAt(index[j]));
            }
            if (!keys.contains(tmp.toString())) {
                keys.add(tmp.toString());
            }
        } while (keys.size() < keysNum);
        return keys;
    }

    public static void printList(List<String> l){
        for(String s : l){
            System.out.println(s);
        }
    }
}