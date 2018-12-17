package ru.pyatkinmv.QuickSort;

import java.util.Comparator;

public class ThreeWayQSort<T> extends QSort<T> {

     protected void sort(T[] arr, int first, int last, Comparator c) {
         if (first >= last) return;

         int less = first;
         int greater = last;
         int i = first + 1;
         T value = arr[first];

         while (i <= greater) {
             if (c.compare(arr[i], value) < 0) {
                 swap(arr, less++, i++);
             } else if (c.compare(arr[i], value) > 0) {
                 swap(arr, i, greater--);
             } else {
                 i++;
             }
         }
         sort(arr, first, less - 1, c);
         sort(arr, greater + 1, last, c);
     }
}
