package myarraylist;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyIterable {
    private final int INIT_SIZE = 10;
    private int size;
    private transient T[] myArray;
    private static final Object EMPTY_ARRAY = new Object[0];
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    public MyArrayList() {
        this.myArray = (T[]) new Object[INIT_SIZE];//new T[INIT_SIZE] doesn't work. I don't know why.
        this.size = myArray.length;
    }

    public MyArrayList(T[] EMPTY_ARRAY) {
        this.myArray = EMPTY_ARRAY;
        this.size = myArray.length;
    }

    public MyArrayList(int initialSize) {
        this.size = myArray.length;
        if (initialSize < 0) {
            throw new IllegalArgumentException("Illegal array size: " + initialSize);
        } else {
            this.myArray = (T[]) new Object[initialSize];
        }
    }

    public int size() {
        if (this.size > MAX_ARRAY_SIZE)
            throw new OutOfMemoryError("Array size is more then maximum of integer value!");
        else return this.size;
    }

    private boolean ifLastElementNotNull() {
        int size = this.size();
        if (this.myArray[size - 1] != null) return true;
        else return false;
    }

    private int getFreeElementIndex() {
        int i = 0;
        while (this.myArray[i] != null) {
            i++;
        }
        return i;
    }

    private void expandArray() {
        int oldSize = this.size();
        int newSize = oldSize + 1;
        this.myArray = Arrays.copyOf(this.myArray, newSize);
        //System.out.println("size: " + this.size());
    }

    private void trimArray() {
        int oldSize = this.size();
        int newSize = oldSize - 1;
        this.myArray = Arrays.copyOf(this.myArray, newSize);
    }

    public void add(T element) {
        if (this.ifLastElementNotNull()) {
            this.expandArray();
        }
        this.myArray[this.getFreeElementIndex()] = element;
    }

    public T remove(int index) {
        T removed = this.myArray[this.size() - 1];
        this.trimArray();
        return removed;
    }

    public T get(int index) {
        if (index > this.size() - 1) throw new IndexOutOfBoundsException("Index out of bounds array size!");
        else {
            T element = this.myArray[index];
            return element;
        }
    }

    public void add(int i, T element) {

    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.myArray[i] = null;
        }
        this.size = 0;
    }

    @Override
    public Iterator myIterator() {
        return null;
    }
}
