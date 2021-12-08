package com.adventofcode.day.seven;

import javax.swing.text.Position;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_seven\\input.txt"));

        String[] split = lines.get(0).split(",");

        List<Integer> positions = Arrays.stream(split).map(Integer::parseInt).sorted().collect(Collectors.toList());

        System.out.println(positions);

        int proposed = positions.get(positions.size() / 2);

        long fuel = 0;
        for (int p : positions) {
            for (int i = 1; i <= Math.abs(proposed - p); i++) {
                fuel += i;
            }
        }

        long temp_fuel = 0;
        long smallest = fuel;

        for (int proposed2 = 250; proposed2 < 500; proposed2++) {
            for (int p : positions) {
                for (int i = 1; i <= Math.abs(proposed2 - p); i++) {
                    temp_fuel += i;
                }
            }
            System.out.println(proposed2 + ": " + temp_fuel);
            if (temp_fuel < smallest) {
                smallest = temp_fuel;
                temp_fuel = 0;
            } else {
                temp_fuel = 0;
            }
        }

        System.out.println(fuel);
        System.out.println(smallest);

    }
}
