package ru.pyatkinmv.QuickSort;

import java.util.Comparator;
import java.util.Random;

public abstract class Sort<T> {

    abstract protected void sort(T[] arr, int first, int last, Comparator c);

    public void sort(T[] arr, Comparator c) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1, c);
    }

    protected void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String toString() {
        String name = super.toString();
        name = name.substring(name.lastIndexOf(".") + 1 );
        name = name.substring(0, name.lastIndexOf("@"));
        return name;
    }

    private void shuffle(T[] arr) {
        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(arr, i, index);
        }
    }

}
