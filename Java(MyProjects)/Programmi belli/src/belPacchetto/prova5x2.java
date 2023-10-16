package belPacchetto;

import java.util.*;

public class prova5x2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String stringa = sc.nextLine();
		
		System.out.println("Stringa senza numeri: " + togliNumeri(stringa));
		System.out.println("Stringa senza caratteri speciali: " + togliSpeciali(stringa));
		System.out.println("Stringa ripulita da entrambi: " + togliNumeri(togliSpeciali(stringa)));
		System.out.println("Stringa ripulita da entrambi: " + togliSpeciali(togliNumeri(stringa)));
		System.out.println("Intero ricavato dalla stringa: " + dammiIntero(stringa));
		sc.close();
	}
	public static String togliNumeri(String s) {
		String ris = "";
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!Character.isDigit(c)) {
				ris += c;
			}
		}
		return ris;
	}
	public static String togliSpeciali(String s) {
		String ris = "";
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (Character.isLetter(c) || Character.isDigit(c)) {
				ris += c;
			}
		}
		return ris;
	}
	public static int dammiIntero(String s) {
		String ris = "";
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (Character.isDigit(c)) {
				ris += c;
			}
		}
		Integer Ris = Integer.valueOf(ris);
		return Ris;
	}
	
}
