package belPacchetto;

public class testCaratteri {

	public static void main(String[] args) {
		Character a = 'z';
		String S = a.toString();
		Character b = 123;
		System.out.println(a.hashCode());
		System.out.println(b + "\n");
		
		int test = 0;
		String wow = "-";
		for(int i = 65; i < 91; i++) {
			Character res = (char)i;
			System.out.println(res);
			Character res2 = (char)(i+32);
			System.out.println(res2);
			wow += res.toString() + "/" + res2.toString() + "-";
			test += i + (i + 32);
		}

		System.out.println(test);
		System.out.println(wow);
		System.out.println(wow.hashCode());
		System.out.println(S.hashCode());
	}

	public static String letteraSucc (String s) {
		if(s.length() == 1) {
			if(s.hashCode() >= 97 && s.hashCode() <= 123) {
				Character res = (char)(s.hashCode()+1);
				s = res.toString();
			}	
			return s;
		}else {
			for(int i = 0; i < s.length(); i++) {
				Character tmp = s.charAt(i);
				if(tmp.hashCode() == 123) {
					Character tmp2 = (char)(97);
					s += tmp2;
				}else if(tmp.hashCode() >= 97 && tmp.hashCode() <= 123){
					Character tmp3 = (char)(tmp.hashCode()+1);
					s.replace(s.charAt(i),tmp3);
				}
			}
			return s;
		}
		
	}
	
}
