package ru.pyatkinmv.sort;

import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
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
