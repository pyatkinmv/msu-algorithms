package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class CountingComparator implements Comparator {
    private int compares = 0;
    private Comparator comparator;

    private CountingComparator() {}

    public CountingComparator(Comparator c) {
        comparator = c;
    }

    public int compare(Object o1, Object o2) {
        ++compares;
        return comparator.compare(o1, o2);
    }

    public int getCompares() {
       return compares;
    }
}
