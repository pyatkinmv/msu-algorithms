package ru.pyatkinmv.sort;

import java.util.Comparator;

public class CountingComparator<T> implements Comparator<T> {
    private int compares = 0;
    private Comparator<T> comparator;

    public CountingComparator(Comparator<T> c) {
        comparator = c;
    }

    public int getCompares() {
        return compares;
    }

    public void reset() {
        compares = 0;
    }

    public int compare(T o1, T o2) {
        ++compares;
        return comparator.compare(o1, o2);
    }

}
