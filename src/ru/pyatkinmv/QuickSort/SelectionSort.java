package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class SelectionSort<T> extends Sort<T> {
    @Override
    protected void sort(T[] arr, int first, int last, Comparator c) {
        for (int min = 0; min < arr.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (c.compare(arr[j], arr[least]) < 0) {
                    least = j;
                }
            }
            swap(arr, min, least);
        }
    }
}
