package ru.pyatkinmv.sort;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private int numOfSortsRun;
    private int averageNumOfCompares;
    private double averageTime;

    public void addCompare(int numOfCompares, double time) {
        averageNumOfCompares = (numOfSortsRun * averageNumOfCompares + numOfCompares) / (numOfSortsRun + 1);
        averageTime = (numOfSortsRun * averageTime + time) / (numOfSortsRun + 1);
        ++numOfSortsRun;
    }

    public int getAverageNumOfCompares() {
        return averageNumOfCompares;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public int getNumOfSortRuns() {
        return numOfSortsRun;
    }

}
