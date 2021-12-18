package day2;

import common.InputHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Day 2: Dive!
 */
public class Day2 {

    private HashMap<String, Integer> directions;
    private int depth;
    private int horizontalPosition;

    public Day2() {
        directions = new HashMap<>();
    }

    public void dive() throws FileNotFoundException {
        ArrayList<String> input = InputHandler.readStrings(new File("src/day2/Input.txt"));

        parseDirectionsPartOne(input);
        int depth = calculateDepth();
        int horizontalPosition = retrieveHorizontalPosition();
        System.out.println("Day 2, first half: " + depth * horizontalPosition);

        parseDirectionsPartTwo(input);
        System.out.println("Day 2, second half: " + this.depth * this.horizontalPosition);
    }

    /**
     * The first half of the puzzle
     * What do you get if you multiply your final horizontal position by your final depth?
     */
    private void parseDirectionsPartOne(ArrayList<String> input) {
        for (String direction : input) {
            String[] strings = direction.split(" ");
            mapDirections(strings[0], Integer.parseInt(strings[1]));
        }
    }

    private void mapDirections(String key, int value) {
        if (directions.containsKey(key)) {
            directions.put(key, directions.get(key) + value);
        } else {
            directions.put(key, value);
        }
    }

    private int calculateDepth() {
        return directions.get("down") - directions.get("up");
    }

    private int retrieveHorizontalPosition() {
        return directions.get("forward");
    }

    /**
     * The second half of the puzzle
     * What do you get if you multiply your final horizontal position by your final depth, according to the new instructions?
     */
    private void parseDirectionsPartTwo(ArrayList<String> input) {
        int aim = 0;
        for (String direction : input) {
            String[] strings = direction.split(" ");

            switch (strings[0]) {
                case "down":
                    aim = aim + Integer.parseInt(strings[1]);
                    break;
                case "up":
                    aim = aim - Integer.parseInt(strings[1]);
                    break;
                case "forward":
                    depth = depth + aim * Integer.parseInt(strings[1]);
                    horizontalPosition = horizontalPosition + Integer.parseInt(strings[1]);
                    break;
            }
        }
    }
}
