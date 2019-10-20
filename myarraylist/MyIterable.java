package myarraylist;

import java.util.Iterator;

public interface MyIterable<T> {
    Iterator<T> myIterator();
}