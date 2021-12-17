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

    public Day2() {
        this.directions = new HashMap<>();
    }

    public void dive() throws FileNotFoundException {
        ArrayList<String> input = InputHandler.readFile(new File("src/day2/Input.txt"));
        parseDirections(input);

        // First half of the puzzle
        // What do you get if you multiply your final horizontal position by your final depth?
        int depth = calculateDepth();
        int horizontalPosition = getHorizontalPosition();
        System.out.println("Day 2, first half: " + depth * horizontalPosition);

        // Second half of the puzzle
        // What do you get if you multiply your final horizontal position by your final depth, according to the new instructions?
    }

    private void parseDirections(ArrayList<String> input) {
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

    private int getHorizontalPosition() {
        return directions.get("forward");
    }
}
