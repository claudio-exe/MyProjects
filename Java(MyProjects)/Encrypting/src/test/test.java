package test;

import java.util.LinkedList;

public class test {

    static LinkedList<String> coppie = new LinkedList<>();

    public static void main(String[] args) {
        generateCouples1("w8", 3);
        System.out.println(coppie);
        System.out.println(coppie.size());
        System.out.println(coppie.get(0));
    }

    private static void generateCouples1(String str, int coupleLength) {
        int n = (int) Math.pow(str.length(), coupleLength);
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
}