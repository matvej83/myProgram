package myGenerics;

import java.util.Arrays;

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
