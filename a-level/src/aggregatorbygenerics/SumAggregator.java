package aggregatorbygenerics;

public class SumAggregator implements Aggregator<Integer, Integer> {
    @Override
    public Integer aggregate(Integer[] items) throws NullPointerException {
        Integer sum = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) throw new NullPointerException("The array element is null!");
            sum += items[i];
        }
        return sum;
    }
}