
public class operationsWithNumbers {

	public static void main(String[] args) {
		int theNumber = (int) (Math.random()*1000000000);
		System.out.println("the number is: "+theNumber);
		//converting the number in the string
		String theNumberAsString = Integer.toString(theNumber);
		//converting the string in the array of char
		char [] theNumberAsChar = theNumberAsString.toCharArray();
		//moving from right to left and reading the digits of the number
		for (int i = theNumberAsString.length()-1; i>=0; i--){
			char theDigitOfNumber = theNumberAsChar [i];
			if (Character.getNumericValue(theDigitOfNumber)%2==0 && Character.getNumericValue(theDigitOfNumber)%3==0) {
				System.out.print(theDigitOfNumber+" is fizzbuzz, ");
			}
			else if (Character.getNumericValue(theDigitOfNumber)%2==0) {
				System.out.print(theDigitOfNumber+" is fizz, ");
					}
			else if (Character.getNumericValue(theDigitOfNumber)%3==0) {
				System.out.print(theDigitOfNumber+" is buzz, ");
					}
			}
		System.out.println();
		//moving from left to right and reading the digits of the number
		for (int i = 0; i<theNumberAsString.length(); i++){
			char theDigitOfNumber = theNumberAsChar [i];
			if (Character.getNumericValue(theDigitOfNumber)%2==0 && Character.getNumericValue(theDigitOfNumber)%3==0) {
				System.out.print(theDigitOfNumber+" is fizzbuzz, ");
			}
			else if (Character.getNumericValue(theDigitOfNumber)%2==0) {
				System.out.print(theDigitOfNumber+" is fizz, ");
			}
			else if (Character.getNumericValue(theDigitOfNumber)%3==0) {
				System.out.print(theDigitOfNumber+" is buzz, ");
			}
		}
		System.out.println();
		//alternative method
		//moving from right to left and reading the digits of the number
		int counter=0;
		for (;theNumber>0; theNumber/=10){
			if ((theNumber%10)%2==0 && (theNumber%10)%3==0) {
				System.out.print(theNumber%10+" is fizzbuzz, ");
			}
			else if ((theNumber%10)%2==0) {
				System.out.print(theNumber%10+" is fizz, ");
			}
			else if ((theNumber%10)%3==0) {
				System.out.print(theNumber%10+" is buzz, ");
			}
			counter++;
		}
		//moving from left to right and reading the digits of the number
		System.out.println(counter);
		int tenInNPower=10;
		for (int i=1; i<(counter-1); i++){
			tenInNPower*=10;
		}
		System.out.println(tenInNPower);
		theNumber=theNumber/tenInNPower;
		System.out.println(theNumber);
	}
}