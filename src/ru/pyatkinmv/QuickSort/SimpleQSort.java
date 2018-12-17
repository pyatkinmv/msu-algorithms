package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class SimpleQSort<T> extends QSort<T> {

    protected void sort(T[] arr, int first, int last, Comparator c) {
        if (first < last) {
            int p = partition(arr, first, last, c);
            sort(arr, first, p - 1, c);
            sort(arr, p, last, c);
        }
    }
}
