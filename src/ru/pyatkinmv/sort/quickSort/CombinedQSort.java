package ru.pyatkinmv.sort.quickSort;

import java.util.Comparator;

public class CombinedQSort<T> extends InsertionQSort<T> {

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        while (first < last) {
            if (last - first > THRESHOLD) {
                int p = partition(arr, first, last, c);

                if (p - first < last - p) {
                    sort(arr, first, p - 1, c);
                    first = p;
                } else {
                    sort(arr, p, last, c);
                    last = p - 1;
                }
            } else {
                insertionSort.sort(arr, first, last, c);
                last = first;
            }
        }
    }

}
