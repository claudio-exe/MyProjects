package belPacchetto;

public class sostituisciLettere {

	public static void main(String[] args) {

		String s = "AAAZZ";
		System.out.println(letteraSucc1(s));

	}

	public static String letteraSucc(String s) {
		if (s.length() == 1) {
			int hc = s.hashCode();
			if ((hc >= 97 && hc <= 122) || (hc >= 65 && hc <= 89)) {
				Character res = (char) (s.hashCode() + 1);
				s = res.toString();
			} else if (hc == 123){
				s = "a";
			} else if (hc == 90){
				s = "A";
			}
			return s;
		} else {
			
			String stemp = "";
			for (int i = 0; i < s.length(); i++) {
				Character tmp = s.charAt(i);
				if (tmp.hashCode() >= 97 && tmp.hashCode() < 122) {
					tmp = (char) (tmp.hashCode() + 1);
					s = s.replace(s.charAt(i), tmp);
					stemp += s.charAt(i);
				}
				if (s.charAt(s.length()-1) == 122) {
					stemp += s.charAt(i);
					stemp += (char)(97);
				}
				tmp = null;
			}
			return stemp;
		}

	}

	public static String letteraSucc1(String s) {
		if (s.length() == 1) {
			int hc = s.hashCode();
			if ((hc >= 97 && hc <= 122) || (hc >= 65 && hc <= 89)) {
				Character res = (char) (s.hashCode() + 1);
				s = res.toString();
			} else if (hc == 123){
				s = "a";
			} else if (hc == 90){
				s = "A";
			}
			return s;
		} else {
			StringBuilder newS = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				Character tmp = s.charAt(i);
				char c = ' ';
				if(Character.isUpperCase(tmp)){
					c = tmp;
					tmp = Character.toLowerCase(tmp);
				}
				if (tmp >= 97 && tmp < 122) {
					tmp = (char) (tmp.hashCode() + 1);
				}
				else if (tmp == 122) {
					tmp = 97;
				}
				if(Character.isUpperCase(c)){
					tmp = Character.toUpperCase(tmp);
				}
				newS.append((char)tmp);
			}
			return newS.toString();
		}
	}
}
