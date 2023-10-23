package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PalindromeKeyGenerator {

    static List<String> KEYS = new ArrayList<>();

    public static void main(String[] args) {
        String h = "imnvwvWVxXYAHMNT8O0o/\\\"'^#*+-_°()[]{}<>";
        KEYS = casualPalindrome(h, 99);

        for (String s : KEYS) {
            System.out.println(s);
        }

        System.out.println(isPalindrome(KEYS.get(2)));
        System.out.println(KEYS.size());
        System.out.println(KEYS.get(KEYS.size() - 1).length());
        System.out.println(charCount(KEYS.get(KEYS.size() - 1)));
    }

    public static List<String> casualPalindrome(String str, int genLength) {
        str = distinctSymbol(str);
        List<String> keys = new ArrayList();
        int[] indexes = new int[genLength];
        Random rd = new Random();
        do {
            StringBuilder key = new StringBuilder();
            if (genLength % 2 == 0) {
                for (int i = 0; i < genLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indexes[i] = ind;
                    indexes[(genLength - 1) - i] = ind;
                }
            } else {
                for (int i = 0; i < genLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indexes[i] = ind;
                    indexes[(genLength - 1) - i] = ind;
                }
                indexes[(genLength / 2)] = rd.nextInt(str.length());
            }
            for (int j = 0; j < genLength / 2; j++) {
                key.append(str.charAt(indexes[j]));
            }
            for (int j = genLength / 2; j < genLength; j++) {
                switch (Character.toString(str.charAt(indexes[j]))) {
                    case "/":
                        key.append("\\");
                        break;
                    case "\\":
                        key.append("/");
                        break;
                    case "(":
                        key.append(")");
                        break;
                    case ")":
                        key.append("(");
                        break;
                    case "[":
                        key.append("]");
                        break;
                    case "]":
                        key.append("[");
                        break;
                    case "{":
                        key.append("}");
                        break;
                    case "}":
                        key.append("{");
                        break;
                    case "<":
                        key.append(">");
                        break;
                    case ">":
                        key.append("<");
                        break;
                    default:
                        key.append(str.charAt(indexes[j]));
                }
            }
            if (!keys.contains(key.toString())) {
                keys.add(key.toString());
            }
        } while (keys.size() < str.length() * 100);
        return keys;
    }

    public static boolean isPalindrome(String x) {
        StringBuilder y = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--) {
            if (x.length() % 2 != 0 && i == x.length() / 2) {
                y.append(x.charAt(i));
                continue;
            }
            switch (Character.toString(x.charAt(i))) {
                case "/":
                    y.append("\\");
                    break;
                case "\\":
                    y.append("/");
                    break;
                case "(":
                    y.append(")");
                    break;
                case ")":
                    y.append("(");
                    break;
                case "[":
                    y.append("]");
                    break;
                case "]":
                    y.append("[");
                    break;
                case "{":
                    y.append("}");
                    break;
                case "}":
                    y.append("{");
                    break;
                case "<":
                    y.append(">");
                    break;
                case ">":
                    y.append("<");
                    break;
                default:
                    y.append(x.charAt(i));
            }
        }
        if (x.equals(y.toString())) {
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

    public static String charCount(String s) {
        StringBuilder symbol = new StringBuilder();
        do {
            symbol.append("['" + Character.toString(s.charAt(0)) + "'");
            String tmp = s.replace(Character.toString(s.charAt(0)), "");
            int num = s.length() - tmp.length();
            symbol.append(":" + String.valueOf(num) + "]\n");
            s = tmp;
        } while (s.length() > 0);
        symbol.delete(symbol.length() - 1, symbol.length());
        return symbol.toString();
    }

}