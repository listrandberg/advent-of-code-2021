package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    public static ArrayList<Integer> readIntegers(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> integers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            integers.add(scanner.nextInt());
        }

        return integers;
    }

    public static ArrayList<String> readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }
}
