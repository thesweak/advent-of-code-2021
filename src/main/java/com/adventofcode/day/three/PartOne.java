package com.adventofcode.day.three;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartOne {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_three\\input.txt"));

        int[] gamma = new int[lines.get(0).length()];
        int[] epsilon = new int[lines.get(0).length()];

        int one = 0;
        int zero = 0;
        for (int i = 0; i < lines.get(0).length(); i++) {
            for (String s : lines) {
                if (s.charAt(i) == '1') {
                    ++one;
                } else {
                    ++zero;
                }
            }
            if (one >= zero) {
                gamma[i] = 1;
                epsilon[i] = 0;
            } else {
                gamma[i] = 0;
                epsilon[i] = 1;
            }
            one = 0;
            zero = 0;
        }

        StringBuilder g = new StringBuilder();
        StringBuilder e = new StringBuilder();
        for (int i = 0; i < gamma.length; i++) {
            g.append(gamma[i]);
            e.append(epsilon[i]);
        }

        System.out.println(g);
        System.out.println(e);

        System.out.println(Integer.parseInt(String.valueOf(g), 2) * Integer.parseInt(String.valueOf(e), 2));

    }

}
