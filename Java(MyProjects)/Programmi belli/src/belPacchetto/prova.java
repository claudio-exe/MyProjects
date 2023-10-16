package belPacchetto;

public class prova {

	public static void main(String[] args) {

		String nuova = "";
		nuova += "ci a  o";
		int z = 99;
		String s = String.valueOf(z);
		int y = Integer.parseInt(s);
		y += 1;
		System.out.println(senzaSpazi(nuova));
		System.out.println(y);

		System.out.println(isPalindrome(123));
		System.out.println(reverseInt(123456789));
		System.out.println(isPalindrome2("1i tOpI NoN AvEvAnO NiPoTi1"));
		System.out.println(senzaSpazi("1i tOpI NoN AvEvAnO NiPoTi1 \n 1i tOpI NoN AvEvAnO NiPoTi1"));
	}

	public static int reverseInt(int x) {
		String s = String.valueOf(x);
		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			s1 += s.charAt(i);
		}
		Integer risultato = Integer.valueOf(s1);
		return risultato;
	}
	
	public static String senzaSpazi(String s) {
		String str = s.replaceAll("\\s+","");
		return str;
	}
	
	public static String reverseString(String s) {
		String str = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			str += s.charAt(i);
		}
		return str;
	}

	public static boolean isPalindrome(int x) {
		boolean verifica = true;
		if (x < 0) {
			verifica = false; 
		} else {
			String num = String.valueOf(x);
			String numero = "";
			for (int i = num.length() - 1; i >= 0; i--) {
				numero += num.charAt(i);
			}
			int y = Integer.parseInt(numero);
			if (x == y) {
				verifica = true;
			} else {
				verifica = false;
			}
		}
		return verifica;
	}
	
	public static boolean isPalindrome2(String s) {
		boolean palindrome = false;
		String str = senzaSpazi(reverseString(s)).toLowerCase();
		if(str.equals(senzaSpazi(s).toLowerCase())) {
			palindrome = true;
		}else {
			palindrome = false;
		}
		return palindrome;
	}

}
