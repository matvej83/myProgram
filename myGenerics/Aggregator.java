package myGenerics;

public interface Aggregator<A, T> {
    A aggregate(T[] items);
}
