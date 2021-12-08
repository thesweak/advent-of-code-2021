package com.adventofcode.day.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {

    public static void main(String[] args) throws IOException {
        List<Integer> elements = Files.lines(Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_one\\input.txt"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int counter = 0;

        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i) < elements.get(i + 1)) {
                ++counter;
            }
        }

        System.out.println(counter);
    }

}
