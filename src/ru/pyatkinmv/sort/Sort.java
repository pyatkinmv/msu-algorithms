package ru.pyatkinmv.sort;

import java.util.Comparator;

public interface Sort<T> {

    void sort(T[] arr, Comparator c);

    void sort(T[] arr, int first, int last, Comparator c);

}
