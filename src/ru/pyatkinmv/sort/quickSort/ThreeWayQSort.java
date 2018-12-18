package ru.pyatkinmv.sort.quickSort;

import ru.pyatkinmv.sort.Sort;

import java.util.Comparator;

import static ru.pyatkinmv.sort.ArrayUtils.swap;

public class ThreeWayQSort<T> extends QSort<T> {

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        if (first >= last) return;
        int less = first;
        int greater = last;
        int i = first + 1;
        T pivot = getPivot(arr, first, last, c);

        while (i <= greater) {
            if (c.compare(arr[i], pivot) < 0) {
                swap(arr, less++, i++);
            } else if (c.compare(arr[i], pivot) > 0) {
                swap(arr, i, greater--);
            } else {
                ++i;
            }
        }

        sort(arr, first, less - 1, c);
        sort(arr, greater + 1, last, c);
    }

}
