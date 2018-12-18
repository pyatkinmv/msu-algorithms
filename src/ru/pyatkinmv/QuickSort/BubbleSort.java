package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class BubbleSort<T> extends Sort<T> {

    @Override
    protected void sort(T[] arr, int first, int last, Comparator c) {
        for(int i = arr.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

}
