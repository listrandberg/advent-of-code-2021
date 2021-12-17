package day1;

import common.InputHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Day 1: Sonar Sweep
 */
public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> measurements = InputHandler.readFile(new File("src/day1/Input.txt"));

        //System.out.println(countMeasurements(measurements));
        System.out.println(countIncreases(measurements));
    }

    // The first half of the puzzle - How many measurements are larger than the previous measurement?
    private static int countMeasurements(ArrayList<Integer> measurements) {
        int increases = 0;
        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1)) {
                increases++;
            }
        }
        return increases;
    }

    // The second half of the puzzle - How many sums are larger than the previous sum?
    private static int countIncreases(ArrayList<Integer> measurements) {
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

    private static boolean isIncreased(int first, int second) {
        return second > first;
    }
}
