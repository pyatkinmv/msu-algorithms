package ru.pyatkinmv.sort.quickSort;

import ru.pyatkinmv.sort.InsertionSort;

import java.util.Comparator;

public class InsertionQSort<T> extends BasicQSort<T> {

    protected static final int THRESHOLD = 10;

    protected InsertionSort<T> insertionSort;

    public InsertionQSort() {
        insertionSort = new InsertionSort<>();
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        int dim = last - first;
        if (dim > THRESHOLD) {
            int p = partition(arr, first, last, c);
            sort(arr, first, p - 1, c);
            sort(arr, p, last, c);
        } else if (dim > 0) {
            insertionSort.sort(arr, first, last, c);
        }
    }

}
