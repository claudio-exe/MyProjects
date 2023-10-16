package belPacchetto;

public class funzioni {

	public static void main(String[] args) {
		int x = funzione(1);
		System.out.println(x);
		
		int x2 = funzione2(2, 3);
		System.out.println(x2);
		
		int x3 = funzione3(4, 4);
		System.out.println(x3);
		
	}

	public static int funzione(int n) {
		if(n == 0) {
			return 1;
		}else{
			return n * (funzione(n-1) + 1);
		}
	}
	/* SPIEGAZIONE
	 * 
	 * a = 0
	 * 1
	 * 
	 * a = 1
	 * 1 * 2
	 * 2
	 * 
	 * a = 2
	 * 2 * 3
	 * 6
	 * 
	 * a = 3
	 * 3 * 7
	 * 21
	 *
	 */
	
	public static int funzione2(int a, int b) {
		if (a <= 0 && !(b % 2 == 0)) {
			return a - b;
		} else {
			return funzione2(a - 1, b - 1) + 2 * funzione2(b - 2, a - 2);
		}
	}

	public static int funzione3(int x, int y) {
		if (x <= 2 && (y % 2 == 0)) {
			return x + y;
		} else {
			return funzione3(x - 1, y - 1) + 2 * funzione3(y - 2, x - 1);
		}
	}
}
