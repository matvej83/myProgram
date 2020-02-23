import java.util.*;

/***
 * This program is a part of home task.
 * Realize method areFibNumbers, that receive variable number of integer numbers.
 * Method return boolean value, that equals true, if all of input arguments are elements of Fibonacci sequence.
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int theFirstNumber = 0, theSecondNumber = 0, theThirdNumber = 0, theFourthNumber = 0, theFifthNumber = 0;
        boolean newResult = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input five numbers from Fibonacci sequence. After entering each number press <Enter> key:");
        theFirstNumber = sc.nextInt();
        theSecondNumber = sc.nextInt();
        theThirdNumber = sc.nextInt();
        theFourthNumber = sc.nextInt();
        theFifthNumber = sc.nextInt();
        System.out.println("You enter such numbers: " + theFirstNumber + "\t" + theSecondNumber + "\t" + theThirdNumber +
				"\t" + theFourthNumber + "\t" + theFifthNumber);
        newResult = areFibNumbers(theFifthNumber, theSecondNumber, theThirdNumber, theFourthNumber, theFifthNumber);
        System.out.println(newResult ? "Entered numbers are members of Fibonacci sequence" :
				"Entered numbers are not a members of Fibonacci sequence");
        sc.close();
    }

    public static boolean areFibNumbers(int... numbers) {
        boolean result = false;
        Arrays.sort(numbers);
        //building Fibonacci sequence
        //begin
        int fibNumber0 = 0, fibNumber1 = 1, fibNumberN = 0, counter = 2, numberOfMatches = 0;
        while (fibNumberN < numbers[numbers.length - 1]) {
            fibNumberN = fibNumber0 + fibNumber1;
            fibNumber0 = fibNumber1;
            fibNumber1 = fibNumberN;
            counter++;
        }
        int[] fibNumbers = new int[counter];
        fibNumbers[0] = 0;
        fibNumbers[1] = 1;
        for (int i = 2; i < fibNumbers.length; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        //end
        //searching entered numbers in Fibonacci sequence and counting matches
        for (int i = 0; i < numbers.length; i++) {
            if (Arrays.binarySearch(fibNumbers, numbers[i]) > 0) {
                numberOfMatches++;
            }
        }
        //the number of matches must be equal amount of numbers
        if (numberOfMatches == numbers.length) {
            result = true;
        } else result = false;
        return result;
    }
}