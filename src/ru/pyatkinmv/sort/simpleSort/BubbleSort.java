package ru.pyatkinmv.sort.simpleSort;

import ru.pyatkinmv.sort.Sort;

import java.util.Comparator;

import static ru.pyatkinmv.sort.ArrayUtils.swap;

public class BubbleSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        for(int i = last; i > first; --i) {
            for (int j = first; j < i; ++j) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

}