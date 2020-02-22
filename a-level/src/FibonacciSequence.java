import java.util.*;
public class FibonacciSequence {
	public static void main(String[] args) {
		int theFirstNumber=0, theSecondNumber=0, theThirdNumber=0, theFourthNumber=0, theFifthNumber=0;
		Scanner sc = new Scanner (System.in);
		System.out.println("Input five numbers. After entering each number press Enter key:");
		theFirstNumber = sc.nextInt();
		theSecondNumber = sc.nextInt();
		theThirdNumber = sc.nextInt();
		theFourthNumber = sc.nextInt();
		theFifthNumber = sc.nextInt();
		System.out.println("You enter such numbers: "+theFirstNumber+"\t"+theSecondNumber+"\t"+theThirdNumber+"\t"+theFourthNumber+"\t"+theFifthNumber);
		sc.close();
	}
}
