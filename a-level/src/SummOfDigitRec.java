import java.util.*;

public class SummOfDigitRec {
    public static void main(String[] args) {
        int theNumber = 0, theSummOfDigit = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number ");
        try {
            theNumber = sc.nextInt();
        }
        catch (Exception e)  {
            System.out.println("Check entered data!");
            System.exit(1);
        }
        System.out.println("The number is " + theNumber);
        theSummOfDigit = getSummOfDigit(theNumber);
        System.out.println("The summ of digit is " + theSummOfDigit);
    }

    public static int getSummOfDigit(int number) {
        if (number <10) {
            return number;
        } else {
            return number%10 + getSummOfDigit(number / 10);
        }
    }
}
