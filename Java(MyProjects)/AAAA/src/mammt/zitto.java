package mammt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class zitto {

	public static void main(String[] args) throws IOException {
		File f2 = new File("canzoni2.txt");
		File dascrivere = new File("song.txt");
		dascrivere.createNewFile();
		String path = f2.getAbsolutePath();
		String daS = dascrivere.getAbsolutePath();
		FileWriter fw = new FileWriter((daS), true);
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		String s = br.readLine();
		String S = "";
		while(!(s == null)) {
			S = s.replace("'", " ") + "\n";
			fw.append(S);
			s = br.readLine();
		}

	}

}
