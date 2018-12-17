package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class InsertionQSort<T> extends QSort<T> {

    protected static final int THRESHOLD = 10;

    public void sort(T[] arr, int first, int last, Comparator c) {
        int dim = last - first;
        if (dim > THRESHOLD) {
            int p = partition(arr, first, last, c);
            sort(arr, first, p - 1, c);
            sort(arr, p, last, c);
        } else if (dim > 0) {
            insertionSort(arr, first, last, c);
        }
    }

    protected void insertionSort(T[] arr,int first, int last, Comparator c) {
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
