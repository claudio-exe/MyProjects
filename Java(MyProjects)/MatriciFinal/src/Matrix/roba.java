package Matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class roba {

	public static void main(String[] args) throws IOException {
		
		double[][] A = {{2, 1, 2},{4, 5, 1},{2, 1, 4}};
		Matrice AA = new Matrice(A);
		stampami(AA);
		String At = AA.toString();
		System.out.println("toString:\n" + At);
		String tmp = At.replace("\n","");
		System.out.println(tmp);
		At = tmp;
		File f2 = new File("fileMatrici.txt");
		String path = f2.getAbsolutePath();
		FileWriter fw = new FileWriter((path), true);
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		fw.append(At + "\n\n");
		fw.close();
		
		
	}

	public static void stampaMatrice(double[][] a) {
		for (int riga = 0; riga < a.length; riga++) {
			System.out.println();
			for (int colonna = 0; colonna < a[riga].length; colonna++) {
				System.out.print(a[riga][colonna] + " ");
			}
		}
	}
	
	public static void stampami(Matrice A) {
		System.out.println(A.getNome());
		for (int riga = 0; riga < A.getRighe(); riga++) {
			for (int colonna = 0; colonna < A.getColonne(); colonna++) {
				System.out.print(A.getVal(riga,colonna) + " ");
			}
			System.out.println();
		}
	}
}
