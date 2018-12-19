package ru.pyatkinmv.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        int len = arr.length;
        int n = 1;
        int shift;
        int sizeOfSecond;
        T[] arr2;

        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) {
                    break;
                }

                sizeOfSecond = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(
                        Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + sizeOfSecond),
                        c);

                for (int i = 0; i < n + sizeOfSecond; ++i) {
                    arr[shift + i] = arr2[i];
                }

                shift += n * 2;
            }
            n *= 2;
        }
    }

    private  T[] merge(T[] arr1, T[] arr2, Comparator c) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int a = 0;
        int b = 0;
        int len = len1 + len2;
        T[] merged = (T[]) new Object[len];

        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (c.compare(arr1[a], arr2[b]) > 0) {
                    merged[i] = arr2[b++];
                }
                else {
                    merged[i] = arr1[a++];
                }
            } else if (b < len2) {
                merged[i] = arr2[b++];
            } else {
                merged[i] = arr1[a++];
            }
        }
        return merged;
    }

}
