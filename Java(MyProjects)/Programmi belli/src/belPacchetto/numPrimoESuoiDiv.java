package belPacchetto;

import java.util.*;

public class numPrimoESuoiDiv {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci un numero");
		int x = in.nextInt();
		LinkedList<Integer> lista = suoiDivisori2(x);

		if (isPrimo(x)) {
			System.out.println("Il numero " + x + " è primo ed è divisibile per 1 e per se stesso");
		} else {
			System.out.println("Il numero " + x + " non è primo");
		}

		if (!isPrimo(x)) {
			if (x == 1) {
				System.out.println("Ha solo un divisore cioè se stesso");
			} else if (x == 0) {
				System.out.println("I suoi divisori sono infiniti");
			} else {
				System.out.println("I suoi divisori sono:");
				int c = 1;
				for (int n : lista) {
					System.out.println(c + ") " + n);
					c++;
				}
			}
		}
		in.close();
	}

	public static boolean isPrimo(int a) {
		if (a <= 0) {
			a = a + (a * 2);
		}
		boolean primo = false;
		int divisore = 0;
		int i = 0;
		if (a <= 1) {
			primo = false;
		} else {
			for (i = 2; i <= a; i++) {
				if (a % i == 0) {
					divisore = i;
					break;
				}
			}
			if (a == divisore) {
				primo = true;
			} else {
				primo = false;
			}
		}
		return primo;
	}

	public static LinkedList<Integer> suoiDivisori2(int a) {
		if (a <= 0) {
			a = a + (-a * 2);
		}
		LinkedList<Integer> divisori = new LinkedList<Integer>();
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				divisori.add(i);
			}
		}
		return divisori;
	}

}
