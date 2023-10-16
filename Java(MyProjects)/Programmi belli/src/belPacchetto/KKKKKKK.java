package belPacchetto;

import java.util.LinkedList;

public class KKKKKKK {

	public static void main(String[] args) {
		System.out.println("Numeri primi da 10 a 50");
		LinkedList<Integer> numeri = trovaNumPrimi(10, 50);
		for (int tmp : numeri) {
			System.out.println(tmp);
		}
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

	public static LinkedList<Integer> trovaNumPrimi(int a, int b) {
		LinkedList<Integer> primi = new LinkedList<Integer>();
		while (a < b) {
			a++;
			if (isPrimo(a)) {
				primi.add(a);
			}
		}
		return primi;
	}

}
