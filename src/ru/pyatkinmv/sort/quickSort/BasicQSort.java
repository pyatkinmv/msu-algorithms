package ru.pyatkinmv.sort.quickSort;

import java.util.Comparator;

import static ru.pyatkinmv.sort.ArrayUtils.swap;

public class BasicQSort<T> extends QSort<T> {

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        if (first >= last) return;

        int p = partition(arr, first, last, c);

        sort(arr, first, p - 1, c);
        sort(arr, p, last, c);
    }

    protected int partition(T[] arr, int first, int last, Comparator c) {
        T pivot = getPivot(arr, first, last, c);
        int i = first;
        int j = last;

        while (i <= j) {
            while (c.compare(arr[i], pivot) < 0) {
                i++;
            }
            while (c.compare(arr[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }
        return i;
    }

}
