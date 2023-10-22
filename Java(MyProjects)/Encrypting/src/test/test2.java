package test;

import java.io.BufferedWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class test2 {

    static List<String> couples = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        StringBuilder bs = new StringBuilder();
        int coupleLength, symbol = 0;
        String alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String gen = "";
        System.out.println("Simboli disponibili per la generazione: \"" + alfa + "\"\nNumero di simboli da usare");
        do{
            symbol = sc.nextInt();
            if(symbol > alfa.length()){
                System.out.println("Simboli disponibili " + alfa.length() + ", inserire un valore valido");
            }
        }while(symbol > alfa.length());
        System.out.println("Lunghezza delle combinazioni");
        coupleLength = sc.nextInt();
        for (int i = 0; i < symbol; i++) {
            int r = rd.nextInt(alfa.length());
            gen += alfa.charAt(r);
            alfa = alfa.replace(Character.toString(alfa.charAt(r)), "");
        }
        File f = new File("Encrypting/combination.txt");
        if (f.exists()) {
            f.delete();
        }
        if (((long) Math.pow(gen.length(), coupleLength)) > 1000000) {
            couples = casualCouples(gen, coupleLength);
        } else {
            generateCouples(gen, coupleLength, sb, bs);
        }
        String path = f.getAbsolutePath();
        FileWriter fw = new FileWriter((path), true);
        for (String tmp : couples) {
            fw.append(tmp + "\n");
        }
        fw.close();
        sc.close();
        System.out.println(couples.size()+" combinazioni generate.\nRisultati inseriti in " + f.getAbsolutePath());
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
        } while (couples.size() < 1000000);
        cop.addAll(couples);
        return cop;
    }

    private static void generateCouples(String str, int coupleLength, StringBuilder currentCouple,
            StringBuilder result) {
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