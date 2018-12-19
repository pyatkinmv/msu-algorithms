package ru.pyatkinmv.sort;

import java.util.Random;

import static ru.pyatkinmv.sort.ArrayUtils.shuffle;

public class IntArrayFactory {
    private int numOfDuplicates;

    public enum ArrayType {
        RANDOM, RANDOM_DISTINCT, SORTED, REVERSED_SORTED, MIRRORED, DUPLICATES
    }

    public IntArrayFactory(int numOfDuplicates) {
        this.numOfDuplicates = numOfDuplicates;
    }

    public Integer[] createArray(int size, ArrayType type) {
        switch (type) {
            case RANDOM: return randomized(size, size);
            case RANDOM_DISTINCT: return randomizedDistinct(size);
            case SORTED: return sorted(size);
            case REVERSED_SORTED: return reversedSorted(size);
            case MIRRORED: return mirrored(size);
            case DUPLICATES: return duplicates(size);
            default: return new Integer[0];
        }
    }

    private Integer[] duplicates(int size) {
        return randomized(size, numOfDuplicates);
    }

    private static Integer[] randomized(int size, int bound) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i) {
            arr[i] = rand.nextInt(bound);
        }

        return arr;
    }

    private static Integer[] randomizedDistinct(int size) {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i) {
            arr[i] = i;
        }

        shuffle(arr);

        return arr;
    }

    private static Integer[] mirrored(int size) {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i){
            arr[i] = (i < size / 2) ? i : size - i;
        }

        return arr;
    }

    private static Integer[] reversedSorted(int size) {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i)
            arr[i] = size - i - 1;

        return arr;
    }

    private static Integer[] sorted(int size) {
        Integer[] arr = new Integer[size];

        for(int i = 0; i < size; ++i) {
            arr[i] = i;
        }

        return arr;
    }

}
