package belPacchetto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RiduciMatrici {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] A = riempiArray(5, 5);
		int[][] B = matRidotta(A, 4, 4);
		stampaMatrice(A);
		System.out.println();
		stampaMatrice(B);
	}

	public static int[][] riempiArray(int righe, int colonne) {
		int temp = 0;
		int[][] array = new int[righe][colonne];
		for (int r = 0; r < righe; r++) {
			System.out.println("Riga " + (r + 1) + ":");
			for (int c = 0; c < colonne; c++) {
				for (int s = 0; s < righe; s++) {
					for (int t = 0; t < colonne; t++) {
						if (s == r && t == c) {
							System.out.print("X" + " ");
						} else {
							temp = array[s][t];
							System.out.print(temp + " ");
						}
					}
					System.out.println();
				}
				array[r][c] = whileIsInt(sc);
			}
		}
		return array;
	}

	private static int[][] matRidotta(int[][] a, int i_del, int j_del) {
		if (i_del > a.length - 1 || j_del > a.length - 1) {
			return null;
		} else {
			int ord = a.length - 1;
			int[][] ridotta = new int[ord][ord];
			int i1 = 0;
			for (int i = 0; i < ord + 1; i++) {
				if (i_del != i) {
					int j1 = 0;
					for (int j = 0; j < ord + 1; j++) {
						if (j_del != j) {
							ridotta[i1][j1] = a[i][j];
							j1++;
						}
					}
					i1++;
				}
			}
			return ridotta;
		}
	}

	public static int whileIsInt(Scanner s) {
		boolean verifica = false;
		int result = 0;
		do {
			try {
				result = s.nextInt();
				verifica = true;
			} catch (InputMismatchException e) {
				System.out.println("Inserito valore non valido\nRiprova.");
				verifica = false;
				s.nextLine();
			}
		} while (!verifica);
		return result;
	}

	public static void stampaMatrice(int[][] a) {
		for (int riga = 0; riga < a.length; riga++) {
			System.out.println();
			for (int colonna = 0; colonna < a[riga].length; colonna++) {
				System.out.print(a[riga][colonna] + " ");
			}
		}
	}

}
