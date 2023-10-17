package pacco;

import java.util.LinkedList;

public class test {

    static LinkedList<String> coppie = new LinkedList<>();

   public static void main(String[] args) {
        System.out.println((int)Math.pow(4,3));
        String c = "abcd";
        StringBuilder kt = new StringBuilder();
        generateCouples(c, 3, new StringBuilder(), kt);
        //System.out.println(kt.toString());
        //generateCouples(c,4);
        for (String string : coppie) {
            System.out.print(string + " ");
        }
        System.out.println(coppie.size());
    }

    private static void generateCouples(String str, int coupleLength, StringBuilder currentCouple, StringBuilder result) {
        if (coupleLength == 0) {
            result.append(currentCouple);
            coppie.add(currentCouple.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            currentCouple.append(str.charAt(i));
            generateCouples(str, coupleLength - 1, currentCouple, result);
            currentCouple.setLength(currentCouple.length() - 1);
        }
    }

    private static void generateCouples(String str, int coupleLength) {
        int n = str.length();

        for (int i = 0; i <= n - coupleLength; i++) {
            String tmp = "";
            for (int j = i + 1; j <= n - coupleLength + 1; j++) {
                tmp += str.substring(i, i + coupleLength);
            }
            coppie.add(tmp);
        }
    }
}