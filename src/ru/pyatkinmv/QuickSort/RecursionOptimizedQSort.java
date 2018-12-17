package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class RecursionOptimizedQSort<T> extends QSort<T> {

    public void sort(T[] arr, int first, int last, Comparator c) {
        while (first < last) {
            int p = partition(arr, first, last, c);

            if (p - first < last - p) {
                sort(arr, first, p - 1, c);
                first = p;
            } else {
                sort(arr, p, last, c);
                last = p - 1;
            }
        }
    }
}
