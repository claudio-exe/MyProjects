package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PalindromeKeyGenerator {

    static List<String> coppie = new ArrayList<>();

    public static void main(String[] args) {
        String h = "imnvwvWVxXYAHMNT8O0o/\\\"()[]{}<>";
        coppie = casualPalindrome(h, 45);

        for (String s : coppie) {
            System.out.println(s);
        }

        System.out.println(isPalindrome(coppie.get(2)));
        System.out.println(coppie.size());
        System.out.println(coppie.get(coppie.size() - 1).length());
    }

    public static List<String> casualPalindrome(String str, int coupleLength) {
        str = distinctSymbol(str);
        Set<String> couples = new HashSet<>();
        List<String> cop = new ArrayList<>();
        int[] indici = new int[coupleLength];
        Random rd = new Random();
        do {
            StringBuilder tmp = new StringBuilder();
            if (coupleLength % 2 == 0) {
                for (int i = 0; i < coupleLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indici[i] = ind;
                    indici[(coupleLength - 1) - i] = ind;
                }
            } else {
                for (int i = 0; i < coupleLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indici[i] = ind;
                    indici[(coupleLength - 1) - i] = ind;
                }
                indici[(coupleLength / 2)] = rd.nextInt(str.length());
            }
            for (int j = 0; j < coupleLength / 2; j++) {
                tmp.append(str.charAt(indici[j]));
            }
            for (int j = coupleLength / 2; j < coupleLength; j++) {
                switch (Character.toString(str.charAt(indici[j]))) {
                    case "/":
                        tmp.append("\\");
                        break;
                    case "\\":
                        tmp.append("/");
                        break;
                    case "(":
                        tmp.append(")");
                        break;
                    case ")":
                        tmp.append("(");
                        break;
                    case "[":
                        tmp.append("]");
                        break;
                    case "]":
                        tmp.append("[");
                        break;
                    case "{":
                        tmp.append("}");
                        break;
                    case "}":
                        tmp.append("{");
                        break;
                    case "<":
                        tmp.append(">");
                        break;
                    case ">":
                        tmp.append("<");
                        break;
                    default:
                        tmp.append(str.charAt(indici[j]));
                }
            }
            if (!couples.contains(tmp.toString())) {
                couples.add(tmp.toString());
            }
        } while (couples.size() < str.length() * 100);
        cop.addAll(couples);
        return cop;
    }

    public static boolean isPalindrome(String x) {
        StringBuilder tmp = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--) {
            if (x.length() % 2 != 0 && i == x.length() / 2) {
                tmp.append(x.charAt(i));
                continue;
            }
            switch (Character.toString(x.charAt(i))) {
                case "/":
                    tmp.append("\\");
                    break;
                case "\\":
                    tmp.append("/");
                    break;
                case "(":
                    tmp.append(")");
                    break;
                case ")":
                    tmp.append("(");
                    break;
                case "[":
                    tmp.append("]");
                    break;
                case "]":
                    tmp.append("[");
                    break;
                case "{":
                    tmp.append("}");
                    break;
                case "}":
                    tmp.append("{");
                    break;
                case "<":
                    tmp.append(">");
                    break;
                case ">":
                    tmp.append("<");
                    break;
                default:
                    tmp.append(x.charAt(i));
            }
        }
        if (x.equals(tmp.toString())) {
            return true;
        } else {
            return false;
        }
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