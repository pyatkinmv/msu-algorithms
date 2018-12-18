package ru.pyatkinmv.sort;

import java.util.Random;

public class ArrayUtils {

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T> void shuffle(T[] arr) {
        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(arr, i, index);
        }
    }
// TODO: needs to be fixed
//    public static <T> T[] copyInRange(T[] arr, int first, int last) {
//        int size = last - first;
//
//        if (size < 0 || arr.length < size)
//            throw new IllegalArgumentException("Incorrect array bounds: first = " + first
//                    + "last = " + last + "arr.length = " + arr.length);
//
//        T[] newArr = (T[]) new Object[size];
//
//        for (int i = 0; i < size; ++i) {
//            newArr[i] = arr[i];
//        }
//
//        return newArr;
//    }

    public static void print(Object[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static Integer[] randIntArr(int bound, int size) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i)
            arr[i] = rand.nextInt(bound);

        return arr;
    }

    public static Integer[] randIntArr(int size) {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i)
            arr[i] = i;

        shuffle(arr);

        return arr;
    }

}
