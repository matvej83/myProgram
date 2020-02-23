package aggregatorbygenerics;

public interface Aggregator<A, T> {
    A aggregate(T[] items);
}
