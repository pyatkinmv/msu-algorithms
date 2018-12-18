package ru.pyatkinmv.sort;

import java.util.Comparator;

public class BubbleSort<T> extends Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        for(int i = last; i > first; --i) {
            for (int j = 0; j < i; ++j) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

}
