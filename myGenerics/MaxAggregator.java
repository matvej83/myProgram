package myGenerics;

public class MaxAggregator<T extends Comparable<? super T>> implements Aggregator<T, T> {
    @Override
    public T aggregate(T[] items) {
        T max = items[0];
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].compareTo(max) > 0)
                max = items[i];
        }
        return max;
    }
}
