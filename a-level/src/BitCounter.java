/***
 * This program is a part of home task:
 * given a Long number. Count the number of bits, that equals 1.
 */
public class BitCounter {

    public static void main(String[] args) {
        long theLongNumber = -24320015678L, theLongNumberTMP;//declaring the long number
        String binaryString = Long.toBinaryString(theLongNumber);
        System.out.println("The long number is " + theLongNumber);
        String StringOfBits = "";//declaring the string for binary number storing
        int bitCounter = 1;
        theLongNumberTMP = Math.abs(theLongNumber);
        while (theLongNumberTMP >= 1) {
            StringOfBits += (theLongNumberTMP % 2);
            theLongNumberTMP /= 2;
            if (theLongNumberTMP % 2 == 1) {
                bitCounter++;
            }
        }
        theLongNumberTMP = theLongNumber;
        if (theLongNumber > 0) {
            StringOfBits = (new StringBuffer(StringOfBits.toString()).reverse().toString());//writing string in reverse order
            System.out.println("The binary representation of the long number is " + StringOfBits);
            System.out.print("The number of bits with the value of '1' is " + bitCounter);
        }
        if (theLongNumber < 0) {
            while (StringOfBits.length() < 64) {
                StringOfBits = "0" + StringOfBits;
            }
            String tmp1 = StringOfBits.replace("1", "a");
            String tmp2 = tmp1.replace("0", "1");
            StringOfBits = tmp2.replace("a", "0");
            System.out.println("The binary representation of the long number is " + binaryString);
            System.out.println("The binary representation of the long number is " + StringOfBits);
            System.out.print("the number of bits with the value of '1' is " + bitCounter);
        }
    }

}
