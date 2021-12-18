package common;

import day1.Day1;
import day2.Day2;
import day3.Day3;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Day1 day1 = new Day1();
        day1.sweep();

        Day2 day2 = new Day2();
        day2.dive();

        Day3 day3 = new Day3();
        day3.diagnose();
    }
}
