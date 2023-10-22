package matr;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Matrice{

	private String nome = "{empty}";
	private int righe;
	private int colonne;
	private double[][] matrice;
	private static Scanner sc = new Scanner(System.in);

	public Matrice() {

	}

	public Matrice(String nome) {

	}
	
	public Matrice (double[][] d) {
		if(d != null) {
			this.matrice = d;
			this.righe = d.length;
			this.colonne = d[d.length - 1].length;
		} else {
			this.matrice = null;
		}
	}

	public Matrice(String nome, int righe, int colonne) {
		if (righe > 0 && colonne > 0) {
			this.matrice = new double[righe][colonne];
			this.nome = nome;
			this.righe = righe;
			this.colonne = colonne;
			for (int n = 0; n < righe; n++) {
				for (int m = 0; m < colonne; m++) {
					this.matrice[n][m] = 0;
				}
			}
		} else {
			System.out.println("Valori non validi\n");
		}
	}

	public Matrice(String nome, int ordine) {
		if (ordine > 0) {
			this.matrice = new double[ordine][ordine];
			this.nome = nome;
			this.righe = ordine;
			this.colonne = ordine;
			for (int n = 0; n < righe; n++) {
				for (int m = 0; m < colonne; m++) {
					this.matrice[n][m] = 0;
				}
			}
		} else {
			System.out.println("Valori non validi\n");
		}
	}

	protected String getNome() {
		return nome;
	}

	protected int getRighe() {
		return righe;
	}

	protected int getColonne() {
		return colonne;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setRighe(int righe) {
		this.righe = righe;
	}

	protected void setColonne(int colonne) {
		this.colonne = colonne;
	}

	private void setM(double[][] d) {
		this.matrice = d;
	}

	public boolean isNull() {
		if (this.matrice == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String stringa = "[" + this.nome + "]" + "\n";
		for (int riga = 0; riga < this.righe; riga++) {
			for (int colonna = 0; colonna < this.colonne; colonna++) {
				if(colonna == 0) {
					stringa += ("|" + this.matrice[riga][colonna] + " ");
				}else if(colonna == this.colonne - 1) {
					stringa += (this.matrice[riga][colonna] + "|");
				}else {
					stringa += (this.matrice[riga][colonna] + " ");
				}
			}
			stringa += "\n";
		}
		return stringa;
	}
	
	protected void cambiaValori(double a) {
		for (int n = 0; n < righe; n++) {
			for (int m = 0; m < colonne; m++) {
				this.matrice[n][m] = a;// oppure setVal(n,m,a);
			}
		}
	}

	protected void setVal(int riga, int colonna, double valore) {
		if (riga > righe || colonna > colonne) {
			System.out.println("Inseriti valori non validi");
		} else {
			this.matrice[riga][colonna] = valore;
		}
	}

	protected void addVal(int riga, int colonna, double valore) {
		if (riga > righe || colonna > colonne) {
			System.out.println("Inseriti valori non validi");
		} else {
			this.matrice[riga][colonna] += valore;
		}
	}

	protected double getVal(int riga, int colonna) {
		Double val = 0.0;
		if (riga > righe || colonna > colonne) {
			System.out.println("Inseriti valori non validi");
		} else {
			val = this.matrice[riga][colonna];
		}
		return val;

	}

	public void setMatrice() {
		Double o = 0.0;
		System.out.println("--Premere invio dopo l'inserimento di ogni valore--");
		System.out.println("--Il valore che si sta inserendo � quello corrispondente alla X--");
		for (int n = 0; n < righe; n++) {
			System.out.println("Inserire la riga " + (n + 1) + " della matrice");
			for (int m = 0; m < colonne; m++) {
				for (int s = 0; s < righe; s++) {
					for (int t = 0; t < colonne; t++) {
						if (s == n && t == m) {
							System.out.print("X" + " ");
						} else {
							o = this.matrice[s][t];
							if (o == Math.round(o)) {
								System.out.print(o.intValue() + " ");
							} else {
								System.out.print(o + " ");
							}
						}
					}
					System.out.println();
				}
				this.matrice[n][m] = whileIsDouble();
			}
		}
	}

	public static Matrice creaMatrice() {
		sc = new Scanner(System.in);
		int r = 0, c = 0;
		boolean b = false, b2 = false;
		System.out.println("Inserire nome matrice");
		String n = sc.nextLine();
		do {
			do {
				System.out.println("Righe Matrice " + n + ":");
				do {
					r = whileIsInt();
					if (r <= 0) {
						System.out.println("Inserito valore non valido.\nRiprova.");
					}
					b = r <= 0;
				} while (b);
				b = r <= 0;
			} while (b);
			do {
				System.out.println("Colonne Matrice " + n + ":");
				do {
					c = whileIsInt();
					if (c <= 0) {
						System.out.println("Inserito valore non valido.\nRiprova.");
					}
					b2 = c <= 0;
				} while (b2);
				b2 = c <= 0;
			} while (b2);
		} while (b && b2);
		Matrice matrice = new Matrice(n, r, c);
		matrice.setMatrice();
		return matrice;
	}

	public static Matrice creaMatriceCasuale() {
		Random rnd = new Random();
		int r = rnd.nextInt(2, 4);
		int c = rnd.nextInt(2, 4);
		Matrice casuale = new Matrice("casuale", r, c);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int numero = rnd.nextInt(-2, 7);
				casuale.setVal(i, j, numero);
			}
		}
		return casuale;
	}

	public static Matrice creaMatriceCasuale(int a, int b) {
		Random rnd = new Random();
		Matrice casuale = new Matrice("casuale", a, b);
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				int numero = rnd.nextInt(-10, 10);
				casuale.setVal(i, j, numero);
			}
		}
		return casuale;
	}

	public void stampaMatrice() {
		Double o = 0.0;
		if (this.matrice == null) {
			if (nome == null) {
				System.out.println("Matrice vuota");
			} else if (nome != null) {
				System.out.println("Matrice " + nome + ":");
				System.out.println("\nInesistente.");
			}
		} else if (this.matrice != null) {
			System.out.println("Matrice " + nome + ":");
			for (int riga = 0; riga < righe; riga++) {
				System.out.println();
				for (int colonna = 0; colonna < colonne; colonna++) {
					o = this.matrice[riga][colonna];
					if (o == Math.round(o)) {
						System.out.print(o.intValue() + " ");
					} else {
						System.out.print(o + " ");
					}
				}
			}
		} else {
			System.out.println("Matrice vuota");
		}
		System.out.println("\n");
	}

	public static Matrice prodotto(Matrice a, Matrice b) {
		String n = "";
		n = "(" + a.getNome() + ")" + "*" + "(" + b.getNome() + ")";
		Matrice axb = new Matrice(" ", 1, 1);
		if (a != null && b != null) {
			if (a.getColonne() != b.getRighe()) {
				axb.setM(null);
			} else {
				double RisInt = 0;
				axb = new Matrice(" ", a.getRighe(), b.getColonne());
				for (int i = 0; i < a.getRighe(); i++) {
					for (int j = 0; j < b.getColonne(); j++) {
						for (int k = 0; k < b.getRighe(); k++) {
							RisInt = a.getVal(i, k) * b.getVal(k, j);
							axb.addVal(i, j, RisInt);
						}
					}
				}
			}
		} else {
			axb.setM(null);
		}
		axb.setNome(n);
		return axb;
	}

	public Matrice prodotto(Matrice a) {
		String n = " ";
		n = "(" + nome + ")" + "*" + "(" + a.getNome() + ")";
		Matrice axb = new Matrice(" ", 1, 1);
		if (this.matrice != null && a != null) {
			if (colonne != a.getRighe()) {
				axb.setM(null);
			} else {
				double RisInt = 0;
				axb = new Matrice(" ", righe, a.getColonne());
				for (int i = 0; i < righe; i++) {
					for (int j = 0; j < a.getColonne(); j++) {
						for (int k = 0; k < a.getRighe(); k++) {
							RisInt = this.matrice[i][k] * a.getVal(k, j);
							axb.addVal(i, j, RisInt);
						}
					}
				}
			}
		} else {
			axb.setM(null);
		}
		axb.setNome(n);
		return axb;
	}

	public static Matrice somma(Matrice a, Matrice b) {
		String n = " ";
		n = "(" + a.getNome() + ")" + "+" + "(" + b.getNome() + ")";
		Matrice ab = new Matrice(" ", 1, 1);
		if (a != null && b != null) {
			if (a.getRighe() != b.getRighe() || a.getColonne() != b.getColonne()) {
				ab.setM(null);
			} else {
				ab = new Matrice(" ", a.getRighe(), b.getColonne());
				for (int i = 0; i < a.getRighe(); i++) {
					for (int j = 0; j < b.getColonne(); j++) {
						ab.addVal(i, j, (a.getVal(i, j) + b.getVal(i, j)));
					}
				}
			}
		} else {
			ab.setM(null);
		}
		ab.setNome(n);
		return ab;
	}

	public static Matrice sottrazione(Matrice a, Matrice b) {
		String n = " ";
		n = "(" + a.getNome() + ")" + "-" + "(" + b.getNome() + ")";
		Matrice ab = new Matrice(" ", 1, 1);
		if (a != null && b != null) {
			if (a.getRighe() != b.getRighe() || a.getColonne() != b.getColonne()) {
				ab.setM(null);
			} else {
				ab = new Matrice(" ", a.getRighe(), b.getColonne());
				for (int i = 0; i < a.getRighe(); i++) {
					for (int j = 0; j < b.getColonne(); j++) {
						ab.addVal(i, j, (a.getVal(i, j) - b.getVal(i, j)));
					}
				}
			}
		} else {
			ab.setM(null);
		}
		ab.setNome(n);
		return ab;
	}

	public Matrice moltiplica(double a) {
		String n = " ";
		n = "(" + nome + "x" + a + ")";
		Matrice a2 = new Matrice(" ", 1, 1);
		if (this.matrice != null) {
			a2 = new Matrice(" ", righe, colonne);
			for (int i = 0; i < righe; i++) {
				for (int j = 0; j < colonne; j++) {
					a2.addVal(i, j, this.matrice[i][j] * a);
				}
			}
			a2.setNome(n);
		} else {
			a2.setM(null);
		}
		return a2;
	}

	public double sommaElementi() {
		double s = 0;
		for (int i = 0; i < righe; i++) {
			for (int j = 0; j < colonne; j++) {
				s += this.matrice[i][j];
			}
		}
		return s;
	}

	public double getDeterminante() {
		if (righe == colonne) {
			return det2(this.matrice, righe);
		} else {
			return 0;
		}
	}

	public Matrice getMatIdentica() {
		Matrice id = toMatrice(matIdentica(righe));
		id.setNome("identit� di ordine " + righe);
		return id;
	}

	public Matrice getTrasposta() {
		Matrice trasp = toMatrice(trasposta(this.matrice));
		trasp.setNome("trasposta di " + nome);
		return trasp;
	}

	public Matrice getMatCoefficienti() {
		Matrice coeff = new Matrice();
		if (righe == colonne) {
			coeff = toMatrice(matriceCoefficienti(this.matrice, righe));
			coeff.setNome("dei coefficienti di " + nome);
			return coeff;
		} else {
			coeff = new Matrice("dei coefficienti di " + nome);
			return coeff;
		}

	}

	public Matrice getInversa() {
		Matrice vuota = new Matrice("inversa di " + nome);
		if (righe == colonne) {
			double determinante = det2(this.matrice, righe);
			if (determinante != 0) {
				/*
				 * double[][] matCoeff = trasposta(matriceCoefficienti(matrice, righe)); Matrice
				 * inv = toMatrice(matCoeff); inv = inv.moltiplica(1 / determinante);
				 */
				// Matrice inv = toMatrice(trasposta(matriceCoefficienti(matrice,
				// righe))).moltiplica(1/determinante);
				Matrice inv = toMatrice(inversa(this.matrice));
				inv.setNome("inversa di " + nome);
				return inv;
			} else {
				return vuota;
			}
		} else {
			return vuota;
		}
	}

	public static Matrice toMatrice(double[][] a) {
		int x = a.length;
		int y = a[a.length - 1].length;
		double z = 0;
		Matrice mat = new Matrice("", x, y);
		for (int n = 0; n < x; n++) {
			for (int m = 0; m < y; m++) {
				z = a[n][m];
				mat.setVal(n, m, z);
			}
		}
		return mat;
	}

	public static double[][] toArray2D(Matrice a) {
		int r = a.getRighe();
		int c = a.getColonne();
		double z = 0;
		double[][] mat = new double[r][c];
		for (int n = 0; n < r; n++) {
			for (int m = 0; m < c; m++) {
				z = a.getVal(n, m);
				mat[n][m] = z;
			}
		}
		return mat;
	}

	private static double[][] matIdentica(int ordine) {
		double[][] matrice = new double[ordine][ordine];
		for (int i = 0; i < ordine; i++) {
			for (int j = 0; j < ordine; j++) {
				if (i == j) {
					matrice[i][j] = 1;
				} else {
					matrice[i][j] = 0;
				}
			}
		}
		return matrice;
	}

	private static double det2(double[][] MAT, int ordine) {
		if (ordine == 1) {
			return MAT[0][0];
		}
		if (ordine == 2) {
			return MAT[0][0] * MAT[1][1] - MAT[0][1] * MAT[1][0];
		}
		double d = 0, segno = -1;
		for (int s = 0; s < ordine; ++s) {
			double[][] matJ = matRidotta(MAT, 0, s);
			d += (segno *= -1) * MAT[0][s] * det2(matJ, ordine - 1);
		}
		return d;
	}

	private static double[][] matRidotta(double[][] a, int i_del, int j_del) {
		if (i_del > a.length - 1 || j_del > a.length - 1) {
			return null;
		} else {
			int ord = a.length - 1;
			double[][] ridotta = new double[ord][ord];
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

	private static double[][] trasposta(double[][] d) {
		int colonne = d.length;
		int righe = d[colonne - 1].length;
		double[][] t = new double[righe][colonne];
		for (int i = 0; i < righe; i++) {
			for (int j = 0; j < colonne; j++) {
				t[i][j] = d[j][i];
			}
		}
		return t;
	}

	private static double[][] matriceCoefficienti(double[][] MAT, int ordine) {
		double[][] d = new double[ordine][ordine];
		for (int l = 0; l < ordine; l++) {
			for (int s = 0; s < ordine; s++) {
				double[][] matrid = matRidotta(MAT, l, s);
				int ord = matrid.length;
				if ((l + s) % 2 == 0) {
					d[l][s] = 1 * det2(matrid, ord);
				} else {
					d[l][s] = -1 * det2(matrid, ord);
				}
			}
		}
		return d;
	}

	public static double[][] inversa(double[][] m) {
		int ordine = m.length;
		double determinante = det2(m, ordine);
		if (m.length == m[m.length - 1].length) {
			if (determinante != 0) {
				double[][] matCoeff = matriceCoefficienti(m, ordine);
				double[][] trasposta = trasposta(matCoeff);
				// oppure -> double[][] result = trasposta(matriceCoefficienti(m, ordine));
				double[][] inversa = new double[ordine][ordine];
				for (int i = 0; i < ordine; i++) {
					for (int j = 0; j < ordine; j++) {
						inversa[i][j] = trasposta[i][j] * (1 / determinante);
					}
				}
				return inversa;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	public static double[][] prodottoMatrici(double[][] a, double[][] b) {
		int righe1 = a.length;
		// int colonne1 = a[righe1 - 1].length;
		int righe2 = b.length, colonne2 = b[righe2 - 1].length;
		double[][] result = new double[righe1][colonne2];
		for (int i = 0; i < righe1; i++) {
			for (int j = 0; j < colonne2; j++) {
				for (int k = 0; k < righe2; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	public static void stampaMatrice(double[][] a) {
		for (int riga = 0; riga < a.length; riga++) {
			System.out.println();
			for (int colonna = 0; colonna < a[riga].length; colonna++) {
				System.out.print(a[riga][colonna] + " ");
			}
		}
	}

	public static int whileIsInt() {
		boolean verifica = false;
		int result = 0;
		do {
			try {
				result = sc.nextInt();
				verifica = true;
			} catch (InputMismatchException e) {
				System.out.println("Inserito valore non valido\nRiprova.");
				verifica = false;
				sc.nextLine();
			}
		} while (!verifica);
		return result;
	}

	public static Double whileIsDouble() {
		boolean verifica = false;
		Double result = 0.0;
		do {
			try {
				result = sc.nextDouble();
				verifica = true;
			} catch (InputMismatchException e) {
				System.out.println("Inserito valore non valido\nRiprova.");
				verifica = false;
				sc.nextLine();
			}
		} while (!verifica);
		return result;
	}

	public static int sceltaMenu(int a, int b) {
		boolean B = false;
		int i = 0;
		do {
			i = whileIsInt();
			if (i >= a && i <= b) {
				B = true;
			} else {
				System.out.println("Inserito valore non valido\nRiprova.");
				B = false;				
			}
		} while (!B);
		sc.nextLine();
		return i;
	}

	public static boolean yesNo(String message) {
		sc = new Scanner(System.in);
		System.out.println(message + "\n[y/n]");
		boolean verifica = false;
		boolean err = false;
		do {
			String C = sc.nextLine();
			err = !C.toLowerCase().equals("y") && !C.toLowerCase().equals("n");
			if (err) {
				System.out.println("Valore non valido\nRiprova.");
			}
			if (C.toLowerCase().equals("y")) {
				verifica = true;
			} else {
				verifica = false;
			}
		} while (err);
		return verifica;
	}
}
