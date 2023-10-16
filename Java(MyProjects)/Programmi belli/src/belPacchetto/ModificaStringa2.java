package belPacchetto;

import java.util.Scanner;

public class ModificaStringa2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire una stringa");
		String parola = scanner.nextLine();
		String senzaspazi = "", contrario = "", alternato = "", ripetuto = "";
		Character c = null;
		
		senzaspazi = parola.replaceAll("\\s+","");
		System.out.println(senzaspazi + "\nQuesta è la stringa inserita senza spazi\n");	
		
		for(int j = parola.length()-1; j>=0; j--)
			contrario += parola.charAt(j);
		System.out.println(contrario + "\nQuesta è la stringa inserita ma al contrario \n");	
		
		for(int k = 0; k < parola.length(); k++)
			if(k % 2 == 0) {
				c = parola.charAt(k);
				alternato += Character.toLowerCase(c);
			}else {
				c = parola.charAt(k);
				alternato += Character.toUpperCase(c);
			}
		System.out.println(alternato + "\nQuesta è la stringa con un carattere maiuscolo ed uno minuscolo ad intervalli di uno \n");
		
		for(int z = 0; z < parola.length(); z++)
			ripetuto += parola + "\n";
			System.out.println(ripetuto + "\nQuesta è la parola ripetuta per il numero di lettere della parola");
		scanner.close();

	}

}
