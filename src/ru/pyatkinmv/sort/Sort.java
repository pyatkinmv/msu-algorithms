package ru.pyatkinmv.sort;

import java.util.Comparator;

public interface Sort<T> {

    public abstract void sort(T[] arr, Comparator c);

    public abstract void sort(T[] arr, int first, int last, Comparator c);

}
