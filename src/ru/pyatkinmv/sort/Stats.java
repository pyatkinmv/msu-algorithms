package ru.pyatkinmv.sort;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private int numOfSortsRun;
    private List<Integer> listOfCompares;
    private List<Double> listOfRunTimes;

    public Stats() {
        numOfSortsRun = 0;
        listOfCompares = new ArrayList<>();
        listOfRunTimes = new ArrayList<>();
    }

    public void addCompare(int numOfCompares, double time) {
        listOfCompares.add(numOfCompares);
        listOfRunTimes.add(time);
        ++numOfSortsRun;
    }

    public int getAverageNumOfCompares() {
        return listOfCompares.stream().mapToInt(Integer::intValue).sum() / numOfSortsRun;
    }

    public double getAverageTime() {
        return listOfRunTimes.stream().mapToDouble(d -> d).sum();
    }

    public int getNumOfSortRuns() {
        return numOfSortsRun;
    }

}
