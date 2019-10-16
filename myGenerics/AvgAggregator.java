package myGenerics;

public class AvgAggregator implements Aggregator<Double, Integer>{

    @Override
    public Double aggregate(Integer[] items) {
        return (new SumAggregator().aggregate(items))/(new CountAggregator<>().aggregate(items)).doubleValue();
    }
}
