package test;

import java.util.*;

public class test {

    static LinkedList<String> coppie = new LinkedList<>();

    public static void main(String[] args) {
        coppie.addAll(casualCouples("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789", 100));
        System.out.println(coppie);
        System.out.println(coppie.getLast());
        System.out.println(coppie.size());
        double avg = 0;
        for(String s : coppie){
            avg += distinctSymbol(s).length();
        }
        avg /= coppie.size();
        System.out.println("Media dei simboli usati: "+avg);
    }

    public static List<String> casualCouples(String str, int coupleLength) {
        Set<String> couples = new HashSet<>();
        List<String> cop = new ArrayList<>();
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
        cop.addAll(couples);
        return cop;
    }

    public static int symbolCount(String s) {
        int j = 0;
        do {
            String tmp = s.replace(Character.toString(s.charAt(0)), "");
            s = tmp;
            j++;
        } while (s.length() > 0);
        return j;
    }

    public static String distinctSymbol(String s) {
        StringBuilder symbol = new StringBuilder();
        do {
            symbol.append(s.charAt(0));
            String tmp = s.replace(Character.toString(s.charAt(0)), "");
            s = tmp;
        } while (s.length() > 0);
        return symbol.toString();
    }

}