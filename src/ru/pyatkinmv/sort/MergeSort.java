package ru.pyatkinmv.sort;

import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        if (first < last) {
            int middle = first + (last - first - 1) / 2;

            sort(arr, first, middle, c);
            sort(arr, middle + 1, last, c);

            merge(arr, first, middle, last, c);
        }
    }

    public void merge(T[] arr, int left, int middle, int right, Comparator c) {
        int lSize = middle - left + 1;
        int rSize = right - middle;

        T[] lArr = (T[])new Object[lSize];
        T[] rArr = (T[])new Object[rSize];

        for (int i = 0; i < lSize; ++i) {
            lArr[i] = arr[left + i];
        }

        for (int i = 0; i < rSize; ++i) {
            rArr[i] = arr[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < lSize && j < rSize) {
            if (c.compare(lArr[i], rArr[j]) < 0) {
                arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
            }
        }

        while (i < lSize) {
            arr[k++] = lArr[i++];
        }

        while (j < rSize) {
            arr[k++] = rArr[j++];
        }
    }

}
