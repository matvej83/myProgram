package aggregatorbygenerics;

import java.util.Arrays;

/***
 * This program has created as a part of home task by the theme "Generics":
 * Create an interface Aggregator with a single method aggregate, that receives an array with type T1, and returns a value
 * with a type T2.
 * Write three realization of this interface:
 *  1. CountAggregator - aggregate method counts an input array length.
 *  2. SumAggregator - aggregate method receives an integer numbers array, and returns the amount.
 *  3. AvgAggregator - aggregate method receives an integer numbers array, and returns the average (can be not an integer)
 *  4. MaxAggregator - aggregate method receives a numbers array with a type T1, extends Comparable<T1> and returns
 *  the maximum value
 */
public abstract class Application {
    public static void main(String[] args) {
        //we've tested aggregate method from SumAggregator class
        Integer[] intArray = new Integer[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }
        Integer sumOfArray = new SumAggregator().aggregate(intArray);
        System.out.print("For given array: " + Arrays.toString(intArray));
        System.out.println(" arrays elements sum is equal " + sumOfArray);
        //we've tested aggregate method from CountAggregator class
        Double[] doubleArray = {0.1, 0.8, 2.5, 3.8, 5.95};
        int lengthOfArray = new CountAggregator<>().aggregate(doubleArray);
        System.out.print("For given array: " + Arrays.toString(doubleArray));
        System.out.println(" the array length is equal " + lengthOfArray);
        //we've tested aggregate method from AvgAggregator class
        Double averageValue = new AvgAggregator().aggregate(intArray);
        System.out.print("For given array: " + Arrays.toString(intArray));
        System.out.println(" the average value is equal " + averageValue);
        //we've tested aggregate method from MaxAggregator
        Comparable tArray[] = {99, 2, 500, 6, 60, 1};
        System.out.print("For given array: " + Arrays.toString(tArray));
        System.out.println(" the maximum value is equal " + new MaxAggregator().aggregate(tArray).toString());
    }
}
