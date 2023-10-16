package belPacchetto;

import java.util.*;

public class AAAAAAAA {

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++) {
			lista.add(i);
		}
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) {
			int numero = it.next();
			if(numero % 2 != 0) {
				it.remove();
			}
		}
		System.out.println(lista.size());
		System.out.println(lista);
		
		int n = 0;
		Object s = 123.1;
		n = (s instanceof Integer ? n = (int)s : 0 );
		System.out.println(n);
		int[][] rrrr = new int[2][2];
		System.out.println("oh fra " + rrrr.length);
	}

}
