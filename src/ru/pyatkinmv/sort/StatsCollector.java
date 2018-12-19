package ru.pyatkinmv.sort;

import ru.pyatkinmv.sort.quickSort.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.copyOfRange;
import static ru.pyatkinmv.sort.IntArrayFactory.ArrayType.RANDOM;
import static ru.pyatkinmv.sort.IntArrayFactory.ArrayType.RANDOM_DISTINCT;

public class StatsCollector {
    private static final int ARRAY_SIZE = 10000;
    private static final int SORT_RUNS = 10;
    private static final int NUM_OF_DUPLICATES = 8;


    public static void main(String... args) {

        Map<Sort, Stats> sortStatsMap = new HashMap<>() {
            {
                put(new BasicQSort<Integer>(), new Stats());
                put(new ThreeWayQSort<Integer>(), new Stats());
                put(new InsertionQSort<Integer>(), new Stats());
                put(new CombinedQSort<Integer>(), new Stats());
                put(new RecursionOptimizedQSort(), new Stats());
                put(new MergeSort<Integer>(), new Stats());
//                put(new InsertionSort<Integer>(), new Stats());
//                put(new SelectionSort<Integer>(), new Stats());
//                put(new BubbleSort<Integer>(), new Stats());
            }
        };

        CountingComparator<Integer> comparator = new CountingComparator<>(Integer::compare);

        Integer[] arr = new IntArrayFactory(NUM_OF_DUPLICATES).createArray(ARRAY_SIZE, RANDOM_DISTINCT);

        for (int i = 0; i < SORT_RUNS; ++i) {

            sortStatsMap.forEach((sortImpl, stats) -> {

                Integer[] copyArr = copyOfRange(arr, 0, arr.length - 1);

                double timeStart = System.currentTimeMillis();

                sortImpl.sort(copyArr, comparator);

                double runTime = (System.currentTimeMillis() - timeStart) / 1000;

                stats.addCompare(comparator.getCompares(), runTime);

                comparator.reset();
            });

        }


        sortStatsMap.forEach((key, value) ->
                System.out.printf("%-25s  |  number of compares: %10d  |  average time: %10f seconds  |  number of runs: %10d\n",
                        key.getClass().getSimpleName(),
                        value.getAverageNumOfCompares(),
                        value.getAverageTime(),
                        value.getNumOfSortRuns()
        ));

        Arrays.sort(arr, comparator);
        System.out.println("Number of comparisons by Arrays.sort: " + comparator.getCompares());
    }

}
