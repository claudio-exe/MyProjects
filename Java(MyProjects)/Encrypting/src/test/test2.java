package test;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    static List<String> couples = new ArrayList<>();
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        StringBuilder bs = new StringBuilder();
        generateCouples("abcdefghijklmnopqrstuvwxyz", 5,sb,bs);
        System.out.println(couples);
        System.out.println(couples.size());

    }

    private static List<String> generateCouples(String str, int coupleLength) {
        List<String> coppie = new ArrayList<>();
        int n = (int) Math.pow(str.length(), coupleLength);
        int[] indici = new int[coupleLength];

        for (int i = 0; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < coupleLength; j++) {
                tmp.append(str.charAt(indici[j]));
            }
            coppie.add(tmp.toString());

            for (int j = coupleLength - 1; j >= 0; j--) {
                indici[j]++;
                if (indici[j] < str.length()) {
                    break;
                }
                indici[j] = 0;
            }
        }

        return coppie;
    }

    private static void generateCouples(String str, int coupleLength, StringBuilder currentCouple, StringBuilder result) {
        if (coupleLength == 0) {
            result.append(currentCouple);
            couples.add(currentCouple.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            currentCouple.append(str.charAt(i));
            generateCouples(str, coupleLength - 1, currentCouple, result);
            currentCouple.setLength(currentCouple.length() - 1);
        }
    }
}