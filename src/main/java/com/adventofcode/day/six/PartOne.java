package com.adventofcode.day.six;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_six\\input.txt"));

        String[] split = lines.get(0).split(",");
        List<Integer> data = new ArrayList<>(Arrays.asList(split)).stream().map(Integer::parseInt).collect(Collectors.toList());

        long[] days = new long[10];

        for (Integer i : data) {
            days[i] += 1;
        }

        for (int i = 0; i < 256; i++) {
            days[9] = days[0];
            days[7] += days[0];
            for (int j = 0; j < days.length - 1; j++) {
                days[j] = days[j + 1];
            }
            days[9] = 0;
        }

        long result = 0;
        for (int i = 0; i < days.length; i++) {
            result += days[i];
        }

        System.out.println(result);

    }

}
