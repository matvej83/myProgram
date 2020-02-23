import java.util.Scanner;

/***
 * Calculate GCD and LCO for two natural numbers.
 */
public class GCDAndLCO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int theFirstNumber, theSecondNumber;
        System.out.println("Input the first number:");
        theFirstNumber = sc.nextInt();
        System.out.println("Input the second number:");
        theSecondNumber = sc.nextInt();
        int theFirstNumberTMP = theFirstNumber, theSecondNumberTMP = theSecondNumber, GCD, LKM;
        while (theFirstNumberTMP != 0 && theSecondNumberTMP != 0) {
            if (theFirstNumberTMP > theSecondNumberTMP) {
                theFirstNumberTMP %= theSecondNumberTMP;
            } else {
                theSecondNumberTMP %= theFirstNumberTMP;
            }
        }
        GCD = theFirstNumberTMP + theSecondNumberTMP;
        System.out.println("the first number is " + theFirstNumber + ", the second number is " + theSecondNumber);
        System.out.println("the GCD is " + GCD);
        LKM = theFirstNumber * theSecondNumber / GCD;
        System.out.println("the LCM is " + LKM);
    }
}
