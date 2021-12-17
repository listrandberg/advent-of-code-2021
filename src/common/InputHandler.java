package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    public static ArrayList<Integer> readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> integers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            integers.add(scanner.nextInt());
        }

        return integers;
    }
}
