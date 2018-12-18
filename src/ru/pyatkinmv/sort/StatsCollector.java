package ru.pyatkinmv.sort;

import ru.pyatkinmv.sort.quickSort.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;
import static ru.pyatkinmv.sort.ArrayUtils.randIntArr;

public class StatsCollector {
    public static final int COUNT = 100;
    public static final int BOUND = 100;

    public static void main(String... args) {

        Map<Sort, Stats> sortStatsMap = new HashMap<>() {
            {
                put(new BasicQSort<Integer>(), new Stats());
                put(new ThreeWayQSort<Integer>(), new Stats());
                put(new InsertionQSort<Integer>(), new Stats());
                put(new CombinedQSort<Integer>(), new Stats());
                put(new InsertionSort<Integer>(), new Stats());
                put(new SelectionSort<Integer>(), new Stats());
                put(new BubbleSort<Integer>(), new Stats());
                put(new MergeSort<Integer>(), new Stats());
            }
        };


        CountingComparator<Integer> comparator = new CountingComparator<>(Integer::compare);

        Integer[] arr = randIntArr(COUNT);

        sortStatsMap.entrySet().forEach(it -> {
            Integer[] copyArr = copyOfRange(arr, 0, arr.length - 1);

            double timeStart = System.currentTimeMillis();

            it.getKey().sort(copyArr, comparator);

            double runTime = System.currentTimeMillis() - timeStart;

            it.getValue().addCompare(comparator.getCompares(), runTime);



            comparator.reset();
//            print(copyArr);
//            System.out.println();
        });

        sortStatsMap.forEach((key, value) ->
                System.out.printf("Number of comparisons by %s: %d, time: %f \n",
                        key.getClass().getSimpleName(),
                        value.getAverageNumOfCompares(),
                        value.getAverageTime()
        ));

        Arrays.sort(arr, comparator);
        System.out.println("Number of comparisons by Arrays.sort: " + comparator.getCompares());
    }
}
