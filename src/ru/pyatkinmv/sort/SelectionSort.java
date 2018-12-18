package ru.pyatkinmv.sort;

import java.util.Comparator;

public class SelectionSort<T> extends Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        for (int i = first; i < last; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < last + 1; j++) {
                if (c.compare(arr[j], arr[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            swap(arr, i, indexOfMin);
        }
    }

}
