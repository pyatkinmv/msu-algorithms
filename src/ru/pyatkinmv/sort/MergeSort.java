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
        int n = 1; // кратность сравнений (сравнивать по 1-му элем., 2-м ...)
        int shift; // сдвиг в перебираемом массиве
        int two_size; // количество элементов для 2-го массива
        T[] arr2;

        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + two_size), c);
                for (int i = 0; i < n + two_size; ++i)
                    arr[shift + i] = arr2[i]; // замена на отсортированное
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private  T[] merge(T[] arr_1, T[] arr_2, Comparator c) {
        int len_1 = arr_1.length;
        int len_2 = arr_2.length;
        int a = 0;
        int b = 0;
        int len = len_1 + len_2; // a, b - счетчики в массивах
        T[] result = (T[]) new Object[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (c.compare(arr_1[a], arr_2[b]) > 0) {
                    result[i] = arr_2[b++];
                }
                else {
                    result[i] = arr_1[a++];
                }
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

}
