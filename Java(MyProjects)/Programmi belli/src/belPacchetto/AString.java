package belPacchetto;

import java.util.Scanner;

public class AString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = "(£%$!&£/&!(&£(&$!(!£) * (A)";
		//boolean b = controllaStringa(S);
		//S = (b == true ? S = "no" : S);
		System.out.println(S);
		
		S = (S.contains("£%$!&£/&!(&£(&$!(!£")? S = "Stringa resettata" : S);
		System.out.println(S);
		
		System.out.println("-----------------------");
		
		String A = sc.nextLine();
		boolean a = A.isEmpty();
		System.out.println(a);
		
		sc.close();
	}
	
	public static boolean controllaStringa(String s) {
		if(s.contains("£%$!&£/&!(&£(&$!(!£")) {
			s = "Contiene";
			return true;
		}else {
			return false;
		}
		
	}

}
