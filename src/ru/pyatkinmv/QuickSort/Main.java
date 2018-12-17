package ru.pyatkinmv.QuickSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main{

    public static void print(Object[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        List<QSort> qSorts = Arrays.asList(
                new SimpleQSort<Integer>(),
                new RecursionOptimizedQSort<Integer>(),
                new ThreeWayQSort<Integer>(),
                new InsertionQSort<Integer>(),
                new CombinedQSort<Integer>()
        );

        qSorts.forEach(it -> {
            Integer[] arr = new Integer[100];
            for(int i = 0; i < 100; ++i)
                arr[i] = i;

            CountingComparator comparator = new CountingComparator(Comparator.comparing(o -> ((Integer) o)));

            it.sort(arr, comparator);

            System.out.println("Number of comparisons by " + it.toString() + ": " + comparator.getCompares());
            print(arr);
            System.out.println();

        });

        Random rand = new Random();
        Integer[] arr = new Integer[100];
        for(int i = 0; i < 100; ++i)
            arr[i] = rand.nextInt(100);

        CountingComparator comparator = new CountingComparator(Comparator.comparing(o -> ((Integer) o)));

        Arrays.sort(arr, comparator);

        System.out.println("Number of comparisons in standard method: " + comparator.getCompares());
    }
}
