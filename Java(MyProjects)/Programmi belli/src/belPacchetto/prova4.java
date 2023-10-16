package belPacchetto;

import java.util.LinkedList;
import java.util.Scanner;

public class prova4 {

	public static void main(String[] args) {
		prova4.trovaNumPrimi();
	}

	public static boolean isPrimo(int a) {
		boolean primo = false;
		int divisore = 0;
		int i = 0;
		if (a == 1) {
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

	public static LinkedList<Integer> trovaNumPrimi() {
		int a = 0, b = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserire numero di partenza da cui cercare numeri primi");
		a = sc.nextInt();
		sc.nextLine();
		System.out.println("a quale numero fermare la ricerca?");
		b = sc.nextInt();
		int q = a;
		LinkedList<Integer> primi = new LinkedList<Integer>();
		if (a == 0 && b == 1) {
			System.out.println("Non ci sono numeri primi in questo intervallo");
		} else {
			while (a < b) {
				a++;
				if (isPrimo(a)) {
					primi.add(a);
				}
			}
			if (primi.size() == 0) {
				System.out.println("Non ci sono numeri primi in questo intervallo");
			} else {
				System.out
						.println("I numeri primi da " + q + " a " + b + " sono " + primi.size() + " e sono i seguenti");
				for (int tmp : primi) {
					System.out.println(tmp);
				}
			}

		}

		sc.close();
		return primi;
	}
}
