package myarraylist;

import java.util.*;

public class MyArrayList<T> implements Iterable<T>{
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
        int newSize = oldSize + 10;
        this.myArray = Arrays.copyOf(this.myArray, newSize);
        this.size = newSize;
    }

    private void trimArray() {
        int oldSize = this.size();
        int newSize = oldSize - 1;
        this.myArray = Arrays.copyOf(this.myArray, newSize);
        this.size = newSize;
    }

    public void add(T element) {
        if (this.ifLastElementNotNull()) {
            this.expandArray();
        }
        this.myArray[this.getFreeElementIndex()] = element;
    }

    public T remove(int index) {
        final T removed = this.get(index);
        System.arraycopy(this.myArray, index, this.myArray, index - 1, this.size - index);
        this.trimArray();
        return removed;
    }

    public T get(int index) {
        if (index > this.size() - 1) throw new IndexOutOfBoundsException("Index is out of bounds array size!");
        else {
            return this.myArray[index];
        }
    }

    public void add(int i, T element) {
        int oldSize = this.size();
        int newSize = oldSize + 1;
        this.myArray = Arrays.copyOf(this.myArray, newSize);
        System.arraycopy(this.myArray, i - 1, this.myArray, i, this.size - i + 1);
        this.myArray[i - 1] = element;
        this.size++;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.myArray[i] = null;
        }
        this.size = 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(myArray);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) obj;
        return size == that.size && Objects.equals(that.myArray, myArray);
    }

    @Override
    public String toString() {
        if (this.size() == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            sb.append(", ").append(this.get(i));
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr<>(this);
    }

    private static final class Itr<E> implements Iterator<E>{

        private MyArrayList<E> element;

        Itr(MyArrayList<E> list) {
            //this.element = new MyArrayList<>(element);
        }

        @Override
        public boolean hasNext() {
            //return element.hasNext();
            return false;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            //MyArrayList <E> next = current.next();
            return null;
        }

        @Override
        public void remove() {

        }
    }
}