package test;

import java.util.*;

public class test {

    static LinkedList<String> coppie = new LinkedList<>();

    public static void main(String[] args) {
        // generateCouples1("abcdefghilmno", 5);
        casualCouples("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789", 100);
        System.out.println(coppie);
        System.out.println(coppie.getLast());
        System.out.println(coppie.size());
    }

    private static void generateCouples1(String str, int coupleLength) {
        long n = (long) Math.pow(str.length(), coupleLength);
        int[] indici = new int[coupleLength];
        int indexLen = coupleLength - 1;
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < coupleLength; j++) {
                tmp += str.charAt(indici[j]);
            }
            for (int z = indexLen; z >= 0; z--) {
                indici[z]++;
                if (indici[z] < str.length()) {
                    break;
                }
                indici[z] = 0;
            }
            coppie.add(tmp);
        }
    }

    public static void casualCouples(String str, int coupleLength) {
        Set<String> couples = new HashSet<>();
        int[] indici = new int[coupleLength];
        Random rd = new Random();
        do {
            StringBuilder tmp = new StringBuilder();
            for (int z = coupleLength - 1; z >= 0; z--) {
                indici[z] = rd.nextInt(str.length());
            }
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indici[j]));
            }
            if (!couples.contains(tmp.toString())) {
                couples.add(tmp.toString());
            }
        } while (couples.size() < 1000);
        coppie.addAll(couples);
    }

    public static int symbolCount(String s) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        int j = 0;
        int count = 0;
        do {
            String tmp = s.replace(Character.toString(alfabeto.charAt(j)), "");
            if (!tmp.equals(s)) {
                count++;
            }
            s = tmp;
            j++;
        } while (s.length() > 0);
        return count;
    }

}