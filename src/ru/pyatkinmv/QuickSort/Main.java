package ru.pyatkinmv.QuickSort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main{

    static int numOfCompars;

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
                new InsertionQSort<Integer>()
        );

        qSorts.forEach(it -> {
            Integer[] arr = new Integer[100];
            for(int i = 0; i < 100; ++i)
                arr[i] = i;

            it.sort(arr, (o1, o2)-> {
                        numOfCompars++;
                        return ((Integer) o1).compareTo((Integer) o2);
                    }
            );
            String name = it.toString();
            name = name.substring(name.lastIndexOf(".") + 1 );
            name = name.substring(0, name.lastIndexOf("@"));
            System.out.println("Number of comparisons by " + name + ": " + numOfCompars);
            print(arr);
            System.out.println();

            numOfCompars = 0;
        });

        Random rand = new Random();
        Integer[] arr = new Integer[100];
        for(int i = 0; i < 100; ++i)
            arr[i] = rand.nextInt(100);

        Arrays.sort(arr, (o1, o2)-> {
            numOfCompars++;
            return o1.compareTo(o2);
        });

        System.out.println("Number of comparisons in standard method: " + numOfCompars);
    }
}
