package ru.pyatkinmv.QuickSort;

import java.util.Comparator;
import java.util.Random;

public abstract class QSort<T> {

    abstract protected void sort(T[] arr, int first, int last, Comparator c);

    public void sort(T[] arr, Comparator c) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1, c);
    }

    private void shuffle(T[] arr) {
        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(arr, i, index);
        }
    }

    protected T getPivot(T[] arr, int first, int last, Comparator c) {
        T middle;
        T x = arr[first];
        T y = arr[first + (last - first) / 2];
        T z = arr[last];
        if (c.compare(x, z) < 0) {
            if (c.compare(x, y) > 0) {
                middle = x;
            } else if (c.compare(y, z) < 0) {
                middle = y;
            } else {
                middle = z;
            }
        } else {
            if (c.compare(x, y) < 0)
                middle = x;
            else if (c.compare(y, z) > 0) {
                middle = y;
            } else {
                middle = z;
            }
        }
        return middle;
    }

    protected T getMiddlePivot(T[] arr, int first, int last) {
        return arr[first + (last - first) / 2];
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

}
