package belPacchetto;
import java.util.Scanner;
public class ModificaStringa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire una stringa");
		String parola = scanner.nextLine();
		
		for(int i = 0; i < parola.length(); i++)
			System.out.print(parola.charAt(i));
		System.out.println("\nQuesta è la stringa inserita senza subire modifiche \n");	
		
		for(int j = parola.length()-1; j>=0; j--)
			System.out.print(parola.charAt(j));
		System.out.println("\nQuesta è la stringa inserita ma al contrario \n");	
		
		for(int k = 0; k < parola.length(); k++)
			if(k % 2 == 0) {
				Character c = parola.charAt(k);
				System.out.print(Character.toLowerCase(c));
			}else {
				Character c = parola.charAt(k);
				System.out.print(Character.toUpperCase(c));
			}
		System.out.println("\nQuesta è la stringa con un carattere maiuscolo ed uno minuscolo ad intervalli di uno");
		scanner.close();
	}

}
