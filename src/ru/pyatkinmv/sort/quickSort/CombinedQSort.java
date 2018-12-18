package ru.pyatkinmv.sort.quickSort;

import java.util.Comparator;

import static ru.pyatkinmv.sort.ArrayUtils.swap;

// CombinedQSort has several those features:
// - tail call optimized
// - insertion sort on arrays with length less than constant THRESHOLD
// - three-way partitioning
public class CombinedQSort<T> extends InsertionQSort<T> {

    @Override
    public void sort(T[] arr, int first, int last, Comparator c) {
        while (first < last) {
            if (last - first > THRESHOLD) {
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

                if (less - first < last - greater) {
                    sort(arr, first, less - 1, c);
                    first = greater + 1;
                } else {
                    sort(arr, greater + 1, last, c);
                    last = less - 1;
                }
            } else {
                insertionSort.sort(arr, first, last, c);
                last = first;
            }
        }
    }

}
