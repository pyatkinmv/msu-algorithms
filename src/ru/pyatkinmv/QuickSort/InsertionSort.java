package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class InsertionSort<T> extends Sort<T> {

    protected void sort(T[] arr,int first, int last, Comparator c) {
        T tmp;
        int j;

        for (int i = first; i < last; i++) {
            if (c.compare(arr[i], arr[i + 1]) > 0) {
                tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && c.compare(tmp, arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = tmp;
            }
        }
    }

}
