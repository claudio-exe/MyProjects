package belPacchetto;

import java.util.*;

public class binario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci un numero");
		Integer n = sc.nextInt();
		sc.nextLine();
		System.out.println("inserisci 0 per trasformare il numero in binario;\n"
				+ "Inserisci 1 per trasformare il numero in base 8;\n"
				+ "Inserisci 2 per trasformare il numero in base 16;\n"
				+ "Inserisci 3 per trasformare il numero in base 10;");
		int selettore = sc.nextInt();
		String ris = "";
		switch (selettore) {
		case 0:
			ris = Integer.toBinaryString(n);
			break;
		case 1:
			ris = Integer.toOctalString(n).toUpperCase();
			break;
		case 2:
			ris = Integer.toHexString(n).toUpperCase();
			break;
		case 3:
			String w = n.toString();
			Integer a = Integer.parseInt(w, 10);
			ris = a.toString();
			break;
		}

		System.out.println(ris);

		System.out.println("\n\n\n________________________\n\n");
		int a1 = Integer.parseInt("-10000000", 2);
		int a2 = Integer.parseInt("11111111", 2);
		String a3 = Integer.toBinaryString(a1 + a2);
		System.out.println(a1 + " sommato con " + a2);
		System.out.println(a3);
		sc.close();
	}

}
