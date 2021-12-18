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

        System.out.println("Day 1, first half: " + countIncreasedMeasurements(measurements));
        System.out.println("Day 1, second half: " + countIncreasedSums(measurements));
    }

    /**
     * The first half of the puzzle
     * How many measurements are greater than the previous measurement?
     */
    private int countIncreasedMeasurements(ArrayList<Integer> measurements) {
        int counter = 0;

        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1)) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * The second half of the puzzle
     * How many sums are greater than the previous sum?
     */
    private int countIncreasedSums(ArrayList<Integer> measurements) {
        int counter = 0;
        int firstSum;
        int secondSum;

        for (int i = 0; i < measurements.size() - 3; i++) {
            int commonSum = measurements.get(i + 1) + measurements.get(i + 2);
            firstSum = measurements.get(i) + commonSum;
            secondSum = commonSum + measurements.get(i + 3);

            if (firstSum < secondSum) {
                counter++;
            }
        }

        return counter;
    }
}
