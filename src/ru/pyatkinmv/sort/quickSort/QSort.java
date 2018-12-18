package ru.pyatkinmv.sort.quickSort;

import ru.pyatkinmv.sort.Sort;

import java.util.Comparator;

import static ru.pyatkinmv.sort.ArrayUtils.shuffle;

public abstract class QSort<T> implements Sort<T> {

    public void sort(T[] arr, Comparator c) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1, c);
    }

    protected T getPivot(T[] arr, int first, int last, Comparator c) {
        // Because of shuffling we can regard first element of array as pivot
        return getFirstElemAsPivot(arr, first);
    }

    private T getFirstElemAsPivot(T[] arr, int first) {
        return arr[first];
    }

    private T getMiddlePivot(T[] arr, int first, int last) {
        return arr[first + (last - first) / 2];
    }

    private T getMedianPivot(T[] arr, int first, int last, Comparator c) {
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

}
