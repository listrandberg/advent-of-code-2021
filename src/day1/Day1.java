package day1;

import common.InputHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Day 1: Sonar Sweep
 */
public class Day1 {

    public void sweep() throws FileNotFoundException {
        ArrayList<Integer> measurements = InputHandler.readIntegers(new File("src/day1/Input.txt"));

        System.out.println("Day 1, first half: " + countMeasurements(measurements));
        System.out.println("Day 1, second half: " + countIncreases(measurements));
    }

    // The first half of the puzzle - how many measurements are larger than the previous measurement?
    private int countMeasurements(ArrayList<Integer> measurements) {
        int increases = 0;
        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1)) {
                increases++;
            }
        }
        return increases;
    }

    // The second half of the puzzle - how many sums are larger than the previous sum?
    private int countIncreases(ArrayList<Integer> measurements) {
        int firstSum = 0;
        int secondSum = 0;
        int counter = 0;

        for (int i = 0; i < measurements.size() - 3; i++) {
            int commonSum = measurements.get(i + 1) + measurements.get(i + 2);
            firstSum = measurements.get(i) + commonSum;
            secondSum = commonSum + measurements.get(i + 3);

            if (isIncreased(firstSum, secondSum)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isIncreased(int first, int second) {
        return second > first;
    }
}
