package matr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileManager {

	public static void main(String[] args) throws IOException {
		File f2 = new File("fileMatrici.txt");
		String path = f2.getAbsolutePath();
		FileWriter fw = new FileWriter((path), true);
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		FileReader fr2 = new FileReader(path);
		BufferedReader br2 = new BufferedReader(fr2);

		String S = " ";
		String t = "";
		S = br.readLine();
		while (S != null) {
			int i = 0;
			String nome = "";
			Character tmp = S.charAt(i);
			if (tmp.toString() == "[") {
				while (tmp.toString() == "]") {
					nome += tmp;
					i++;
					tmp = S.charAt(i);
				}
			}
			i = 0;
			System.out.println(nome);
			S = br.readLine();
		}

		System.out.println(t);
		fw.close();
		br.close();
		fr2.close();
		br2.close();

	}

}
