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

    public static ArrayList<String> readStrings(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> strings = new ArrayList<>();

        while (scanner.hasNextLine()) {
            strings.add(scanner.nextLine());
        }

        return strings;
    }
}
