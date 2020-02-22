package myGenerics;

public class CountAggregator <T> implements Aggregator<Integer, T> {

    @Override
    public Integer aggregate(T[] items) {
        if (items == null) return 0;
        else return items.length;
    }
}