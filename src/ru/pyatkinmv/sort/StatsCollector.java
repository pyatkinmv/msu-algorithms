package ru.pyatkinmv.sort;

import ru.pyatkinmv.sort.quickSort.*;
import ru.pyatkinmv.sort.simpleSort.BubbleSort;
import ru.pyatkinmv.sort.simpleSort.InsertionSort;
import ru.pyatkinmv.sort.simpleSort.SelectionSort;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Arrays.copyOfRange;
import static ru.pyatkinmv.sort.IntArrayFactory.ArrayType.RANDOM_DISTINCT;

public class StatsCollector {
    private static final int ARRAY_SIZE = 10000;
    private static final int SORT_RUNS = 10;
    private static final int NUM_OF_DUPLICATES = 10;

    private Map<Sort, SortInfo> resultMap;

    public StatsCollector() {
        initResultMap();
        collect();
        printResultMap();
    }

    private void initResultMap() {
        resultMap = new HashMap<>() {
            {
                put(new BasicQSort<Integer>(), new SortInfo());
                put(new ThreeWayQSort<Integer>(), new SortInfo());
                put(new InsertionQSort<Integer>(), new SortInfo());
                put(new CombinedQSort<Integer>(), new SortInfo());
                put(new RecursionOptimizedQSort(), new SortInfo());
                put(new MergeSort<Integer>(), new SortInfo());
                put(new StandardSort(), new SortInfo());
                put(new InsertionSort<Integer>(), new SortInfo());
                put(new SelectionSort<Integer>(), new SortInfo());
                put(new BubbleSort<Integer>(), new SortInfo());
            }
        };
    }

    private void collect() {
        CountingComparator<Integer> comparator = new CountingComparator<>(Integer::compare);
        Integer[] arr = new IntArrayFactory(NUM_OF_DUPLICATES).createArray(ARRAY_SIZE, RANDOM_DISTINCT);

        for (int i = 0; i < SORT_RUNS; ++i) {
            for (Map.Entry<Sort, SortInfo> entry : resultMap.entrySet()) {
                Sort sortImpl = entry.getKey();
                SortInfo sortInfo = entry.getValue();
                Integer[] copyArr = copyOfRange(arr, 0, arr.length - 1);

                double timeStart = System.currentTimeMillis();
                sortImpl.sort(copyArr, comparator);
                double runTime = (System.currentTimeMillis() - timeStart) / 1000;

                sortInfo.addCompare(comparator.getCompares(), runTime);
                comparator.reset();
            }
        }
    }

    private void printResultMap() {
        resultMap.forEach((sortImpl, sortInfo) -> {
            StringBuilder format = new StringBuilder();
            format.append("%-25s  |  number of compares: %10d  |  average time: %10f seconds  |  number of runs: %d\n");
            System.out.printf(format.toString(),
                    sortImpl.getClass().getSimpleName(),
                    sortInfo.getAverageNumOfCompares(),
                    sortInfo.getAverageTime(),
                    sortInfo.getNumOfSortRuns());
        });
    }

    public static void main(String... args) {
        new StatsCollector();
    }

}
