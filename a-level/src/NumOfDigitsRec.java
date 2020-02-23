import java.util.*;

/***
 * This program is a part of home task:
 * Write the program for finding the numbers of digits
 */
public class NumOfDigitsRec {
    public static void main(String[] args) {
        int theNumber = 0, theNumOfDigit = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number ");
        try {
            theNumber = sc.nextInt();
            System.out.println("The input number " + theNumber);
            theNumOfDigit = getNumberOfDigit(theNumber);
            System.out.println("The number of digit is " + theNumOfDigit);
        } catch (Exception e) {
            System.out.println("Check entered data!");
        }
    }

    public static int getNumberOfDigit(int number) {
        if (number < 10) {
            return 1;
        } else {
            return getNumberOfDigit(number / 10) + 1;
        }
    }
}
