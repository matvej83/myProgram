//package aLevel;

import java.util.Scanner;

public class Lesson_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the day's number:");
        int theDayNumber = sc.nextInt();
        int DaysInYear = 365, theMonth = 1, theMonthDay = 1;
        String theWeekDay;
        String theDaysOfWeek[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (theDayNumber <= 31) {
            theMonth = 1;
            theMonthDay = theDayNumber;
        } else if (theDayNumber <= 59) {
            theMonth = 2;
            theMonthDay = theDayNumber - 31;
        } else if (theDayNumber <= 90) {
            theMonth = 3;
            theMonthDay=theDayNumber-59;
        } else if (theDayNumber <= 120) {
            theMonth = 4;
            theMonthDay=theDayNumber-90;
        } else if (theDayNumber <= 151) {
            theMonth = 5;
            theMonthDay=theDayNumber-120;
        } else if (theDayNumber <= 181) {
            theMonth = 6;
            theMonthDay=theDayNumber-151;
        } else if (theDayNumber <= 212) {
            theMonth = 7;
            theMonthDay=theDayNumber-181;
        } else if (theDayNumber <= 243) {
            theMonth = 8;
            theMonthDay=theDayNumber-212;
        } else if (theDayNumber <= 273) {
            theMonth = 9;
            theMonthDay=theDayNumber-243;
        } else if (theDayNumber <= 304) {
            theMonth = 10;
            theMonthDay=theDayNumber-273;
        } else if (theDayNumber <= 334) {
            theMonth = 11;
            theMonthDay=theDayNumber-304;
        } else if (theDayNumber <= 365) {
            theMonth = 12;
            theMonthDay=theDayNumber-334;
        }
        theWeekDay = theDaysOfWeek[theDayNumber%7];
        System.out.println("The day of year is " + theDayNumber + ", the month is " + theMonth + ", the day of month is " + theMonthDay + ", the day of week is " + theWeekDay);

        //TASK#2
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
        System.out.println("the first number is "+theFirstNumber+", the second number is "+theSecondNumber);
        System.out.println("the GCD is " + GCD);
        LKM = theFirstNumber * theSecondNumber / GCD;
        System.out.println("the LCM is " + LKM);
    }
}
