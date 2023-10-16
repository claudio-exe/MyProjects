package belPacchetto;

public class prova2{

	public static void main(String[] args) {

		int[] w = { 1, 1, 1, 1, 1 };
		int[] w2 = { 1, 1, 1 };
		int a = sommaTraArray(w, w2);
		System.out.println(a);

		int[][] arr2D = { { 2, 2 }, { 2, 10, 13 }, { 4, 9, 13, 13 }, };
		double b = mediaTraArray(arr2D);
		System.out.println(b);

		int qwerty = funzione(2, 3);
		System.out.println(qwerty);

		int[] multipli = arrayDiMultipli(27, 10);
		for (int q : multipli) {
			System.out.print(q + " ");
		}

		Object o = null;
		if (o instanceof Object) {
			System.out.println("true");
		}

	}

	public static int funzione(int a, int b) {
		if (a <= 0 && !(b % 2 == 0)) {
			return a - b;
		} else {
			return funzione(a - 1, b - 1) + 2 * funzione(b - 2, a - 2);
		}
	}

	public static int sommaTraArray(int[] a, int[] b) {
		int risultato = 0;
		for (int i = 0; i < a.length; i++) {
			risultato += a[i];
		}
		for (int j = 0; j < b.length; j++) { 
			risultato += b[j];
		}
		return risultato;
	}

	public static double mediaTraArray(int[][] a) {
		double risultato = 0.0;
		int contatore = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				risultato += a[i][j];
				contatore++;
			}
		}
		risultato /= contatore;
		return risultato;
	}

	public static int[] arrayDiMultipli(int num, int length) {
		int risultato[] = new int[length];
		for (int i = 0; i < length; i++) {
			risultato[i] = num * (i + 1);
		}
		return risultato;
	}

}
