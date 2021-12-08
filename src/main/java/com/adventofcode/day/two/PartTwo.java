package com.adventofcode.day.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartTwo {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_two\\input.txt"));

        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String s : lines) {
            String[] s1 = s.split(" ");

            if (s1[0].equals("forward")) {
                horizontal += Integer.parseInt(s1[1]);
                depth += Integer.parseInt(s1[1]) * aim;
            } else if (s1[0].equals("down")) {
                aim += Integer.parseInt(s1[1]);
            } else if (s1[0].equals("up")) {
                aim -= Integer.parseInt(s1[1]);
            }
        }

        System.out.println(horizontal * depth);
    }

}
