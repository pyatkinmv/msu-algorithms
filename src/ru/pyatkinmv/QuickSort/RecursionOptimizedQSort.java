package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class RecursionOptimizedQSort<T> extends QSort<T> {

    protected void sort(T[] arr, int first, int last, Comparator c) {
        while (first < last) {
            int pi = partition(arr, first, last, c);

            if (pi - first < last - pi) {
                sort(arr, first, pi - 1, c);
                first = pi;
            } else {
                sort(arr, pi, last, c);
                last = pi - 1;
            }
        }
    }
}
