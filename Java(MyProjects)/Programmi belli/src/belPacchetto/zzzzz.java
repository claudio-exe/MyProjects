package belPacchetto;

public class zzzzz {

	public static void main(String[] args) {
	
		System.out.println(makeNotDecreasing(1231));
		//System.out.println("------"+fibonacci(13));
		//System.out.println(9%10);
	}

	public static int makeNotDecreasing (int number){
		int previousDigit = 9;
		int powerOfTen = 1;
		int result = 0;
		
		while (number != 0){
			int currentDigit = number % 10;
			if (currentDigit >= previousDigit){
				currentDigit = previousDigit;
			}
			
			result = result + currentDigit*powerOfTen;
			powerOfTen = powerOfTen*10;
			previousDigit = currentDigit;
			number = number/10;
		}
		return result;
	}

	public static int fibonacci( int threshold )
	{
		int first = 0, second = 1;
		while ( second < threshold )
		{
			int sum = first + second;
			first = second;
			second = sum;
			System.out.println(sum);
		}
		return first;
	}

}




