package belPacchetto;

import java.util.Scanner;

public class ParoleRipetute {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("scrivere una parola e premere invio");
		String S = sc.nextLine();
		System.out.println("scrivere il numero di volte in cui si vuole visualizzare e premere invio");
		int volte = sc.nextInt();

		int i = 0;
		while (i < volte) {

			System.out.println(S);
			i++;
		}
		sc.close();
	}
	

}