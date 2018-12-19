package ru.pyatkinmv.sort;

import java.util.Arrays;
import java.util.Comparator;

public class StandardSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator c) {
        sort(arr, 0, arr.length - 1, c);
    }

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        Arrays.sort(arr, first, last, c);
    }

}
