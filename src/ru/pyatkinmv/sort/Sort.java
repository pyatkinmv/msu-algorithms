package ru.pyatkinmv.sort;

import java.util.Comparator;

public abstract class Sort<T> {

    abstract public void sort(T[] arr, Comparator c);

    public abstract void sort(T[] arr, int first, int last, Comparator c);

    public String toString() {
        return getClass().getSimpleName();
    }

    protected static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
