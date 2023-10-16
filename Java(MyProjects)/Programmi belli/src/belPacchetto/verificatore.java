package belPacchetto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class verificatore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci un numero");
		int y = scanInt(sc);
		System.out.println("hai inserito " + y);
	}

	public static int scanInt(Scanner s) {
		boolean verifica = false;
		Integer result = 0;
		do {
			try {
				result = s.nextInt();
				verifica = false;
				System.out.println(result + "#");
			} catch (InputMismatchException e) {
				System.out.println("riprova");
				verifica = true;
				s.nextLine();
			}
		} while (verifica);
		return result;
	}

}