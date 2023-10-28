package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PalindromeKeyGenerator {

    static List<String> KEYS = new ArrayList<>();

    public static void main(String[] args) {
        String h = "imnvwvWVxXYAHMNT8O0o!|/\\\"'^#*+-_°()[]{}<>";
        KEYS = palindromeKeyGenerator(h, 3, 10);

        for (String s : KEYS) {
            System.out.println(s + "   --> Palindrome? " + isPalindrome(s));
        }

        System.out.println(charCount(KEYS.get(KEYS.size() - 1)));
        List<String> wrapped = generateWrappedPalindrome(KEYS);
        String wrappedP = wrapped.get(wrapped.size()-1);
        System.out.println(wrappedP);
        System.out.println(wrappedP + "   --> Palindrome? " + isPalindrome(wrappedP));
        String triang = generatesIsoscelesTriangle(KEYS);
        String sctriang = generatesScaleneTriangle(KEYS);
        writeOnFile(triang,"Encrypting/txtFile/Isosceles.txt");
        writeOnFile(sctriang, "Encrypting/txtFile/Scalene.txt");
    }

    public static String generatesIsoscelesTriangle(List<String> l) {
        String wrappedPalindrome = l.get(l.size() - 1);
        StringBuilder result = new StringBuilder();
        int m = l.get(0).length()/2;
        int blanks = l.size() * m;
        for (int i = 0; i < l.size(); i++) {
            int div = (wrappedPalindrome.length() % 2 == 0) ? (wrappedPalindrome.length() / 2) : ((wrappedPalindrome.length() / 2) + 1);
            String sub1 = wrappedPalindrome.substring(0, wrappedPalindrome.length() / 2);
            String sub2 = wrappedPalindrome.substring(div, wrappedPalindrome.length());
            wrappedPalindrome = sub1 + l.get(i) + sub2;
            for (int j = 0; j < blanks; j++) {
                result.append(" ");
            }
            result.append(wrappedPalindrome);
            for (int j = 0; j < blanks; j++) {
                result.append(" ");
            }
            result.append("\n");
            blanks -= m;
        }
        return result.toString();
    }

    public static String generatesScaleneTriangle(List<String> l) {
        String wrappedPalindrome = l.get(l.size() - 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            int div = (wrappedPalindrome.length() % 2 == 0) ? (wrappedPalindrome.length() / 2) : ((wrappedPalindrome.length() / 2) + 1);
            String sub1 = wrappedPalindrome.substring(0, wrappedPalindrome.length() / 2);
            String sub2 = wrappedPalindrome.substring(div, wrappedPalindrome.length());
            wrappedPalindrome = sub1 + l.get(i) + sub2;
            for (int j = 0; j < sub1.length(); j++) {
                result.append(' ');
            }
            result.append(wrappedPalindrome);
            for (int j = 0; j < sub2.length(); j++) {
                result.append(' ');
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static List<String> generateWrappedPalindrome(List<String> l){
        String wrappedPalindrome = l.get(l.size() - 1);
        List<String> wrapped = new ArrayList<>();
        wrapped.add(wrappedPalindrome);
        for (int i = 0; i < l.size(); i++) {
            wrappedPalindrome = wrapped.get(i);
            int div = (wrappedPalindrome.length() % 2 == 0) ? (wrappedPalindrome.length() / 2) : ((wrappedPalindrome.length() / 2) + 1);
            String sub1 = wrappedPalindrome.substring(0, wrappedPalindrome.length() / 2);
            String sub2 = wrappedPalindrome.substring(div, wrappedPalindrome.length());
            wrappedPalindrome = sub1 + l.get(i) + sub2;
            wrapped.add(wrappedPalindrome);
        }
        return wrapped;
    }

    public static void writeOnFile(String s, String p) {
        try {
            File f = new File(p);
            if (f.exists()) {
                f.delete();
            }
            String path = f.getAbsolutePath();
            FileWriter fw = new FileWriter((path), true);
            fw.append(s);
            fw.close();
            System.out.println("Written file at: " + path);
        } catch (IOException e) {
        }
    }

    public static List<String> palindromeKeyGenerator(String str, int keyLength, int keysNum) {
        str = distinctSymbol(str);
        List<String> keys = new ArrayList<>();
        int[] indexes = new int[keyLength];
        Random rd = new Random();
        do {
            StringBuilder key = new StringBuilder();
            if (keyLength % 2 == 0) {
                for (int i = 0; i < keyLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indexes[i] = ind;
                    indexes[(keyLength - 1) - i] = ind;
                }
            } else {
                for (int i = 0; i < keyLength / 2; i++) {
                    int ind = rd.nextInt(str.length());
                    indexes[i] = ind;
                    indexes[(keyLength - 1) - i] = ind;
                }
                indexes[(keyLength / 2)] = rd.nextInt(str.length());
            }
            for (int j = 0; j < keyLength / 2; j++) {
                key.append(str.charAt(indexes[j]));
            }
            for (int j = keyLength / 2; j < keyLength; j++) {
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
            if (keyLength % 2 != 0) {
                String s = "2379§€$£@&%";
                int r = rd.nextInt(s.length());
                key.setCharAt(((keyLength / 2)), s.charAt(r));
            }
            if (!keys.contains(key.toString())) {
                keys.add(key.toString());
            }
        } while (keys.size() < keysNum);
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