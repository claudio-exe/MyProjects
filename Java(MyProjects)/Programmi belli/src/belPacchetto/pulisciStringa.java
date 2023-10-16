package belPacchetto;

import java.util.*;

public class pulisciStringa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String stringa = sc.nextLine();
		Object[] cose = pulisciStringa.controllaStringa(stringa);
		
		String iniziale = (String) cose[0];
		String pulita = (String) cose[1];
		String intero = (String) cose[2];
		String speciali = (String) cose[3];
		/*Sintassi alternativa (pi� corretta)
		String iniziale = "", pulita = "", speciali = "";
		Long intero = 0;
		iniziale = (cose[0] instanceof String ? iniziale = (String)cose[0] : iniziale);
		pulita = (cose[1] instanceof String ? pulita = (String)cose[1] : pulita);
		intero = (cose[2] instanceof String ? intero = (String) cose[2] : intero);
		speciali = (cose[3] instanceof String ? speciali = (String) cose[3] : speciali );
		 */
		
		if (iniziale.equals(pulita)) {
			System.out.println("La stringa inserita non contiente interi");
		} else {
			System.out.println("Stringa iniziale: \n---> " + iniziale);
			System.out.println("Caratteri speciali rimossi dalla stringa: \n---> " + senzaSpazi(speciali));
			System.out.println("Stringa ripulita: \n---> " + senzaSpazi(pulita));
			System.out.println("L'intero contenuto nella stringa �: \n---> " + intero);
		}
		sc.close();
	}

	protected static Object[] controllaStringa(String s) {
		Object[] risultati = new Object[4];
		Character c = null;
		String nuova = "", interoS = "", speciali = "";
		Long intero = null;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (Character.isLetter(c)) {
				nuova += c;
			} else if (Character.isDigit(c)) {
				interoS += c;
			}else if(!(Character.isLetter(c))&&!(Character.isDigit(c))) {
				speciali += c;
			}
		}
		/*
		if (interoS.length() > 0) {
			intero = Long.valueOf(interoS);
			risultati[2] = (Object) intero;
		} else {
			risultati[2] = (Object) intero;
		}
		*/
		risultati[0] = (Object) s;
		risultati[1] = (Object) nuova;
		risultati[2] = (Object) interoS;
		risultati[3] = (Object) speciali;
		return risultati;
	}

	public static String senzaSpazi(String s) {
		String str = s.replaceAll("\\s+","");
		return str;
	}
	
}
