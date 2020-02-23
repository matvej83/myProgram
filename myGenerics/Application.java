package myGenerics;

import java.util.Arrays;

/***
 * Realize the class AppProperties, that stores in itself programm properties (names of properties you sholud choice),
 * this must be an public fields. Fields, that marked by the annotation @PropertyKey (it must be created) - you should
 * initialize from the file with the properties app.properties, that lies in the current directory. Concrete the
 * properties you should choice from "value" parameter of the annotation.
 *
 * Example:
 *
 * @PropertyKey(“connections.limit”)
 * public int maxConnections;
 *
 * In app.properties:
 *
 * connections.limit=64
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
