package belPacchetto;

import java.util.LinkedList;
import java.util.Scanner;

public class trovaNumeriPrimi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire numero di partenza per cercare numeri primi");
		int a = in.nextInt();
		in.nextLine();
		System.out.println("Inserire il numero alla quale fermare l'intervallo");
		int b = in.nextInt();
		LinkedList<Integer> numeri= trovaNumPrimi(a, b);
		System.out.println("Da " + a + " a " + b + " ci sono " + numeri.size() + " numeri primi:");
		for(int tmp : numeri) {
			System.out.println(tmp);
		}
		in.close();
	}

	public static boolean isPrimo(int a) {
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
