package com.adventofcode.day.three;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartTwo {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_three\\input.txt"));


        List<String> oxygen = lines;
        List<String> CO2 = lines;

        int one = 0;
        int zero = 0;
        for (int i = 0; i < lines.get(0).length(); i++) {
            for (String s : oxygen) {
                if (s.charAt(i) == '1') {
                    ++one;
                } else {
                    ++zero;
                }
            }

            int finalI = i;
            if (one >= zero) {
                oxygen = oxygen.stream().filter(a -> a.charAt(finalI) == '1').collect(Collectors.toList());
            } else {
                oxygen = oxygen.stream().filter(a -> a.charAt(finalI) == '0').collect(Collectors.toList());
            }
            one = 0;
            zero = 0;

            if (oxygen.size() == 1) {
                break;
            }
        }

        for (int i = 0; i < lines.get(0).length(); i++) {
            for (String s : CO2) {
                if (s.charAt(i) == '1') {
                    ++one;
                } else {
                    ++zero;
                }
            }

            int finalI = i;
            if (one >= zero) {
                CO2 = CO2.stream().filter(a -> a.charAt(finalI) == '0').collect(Collectors.toList());
            } else {
                CO2 = CO2.stream().filter(a -> a.charAt(finalI) == '1').collect(Collectors.toList());
            }
            one = 0;
            zero = 0;

            if (CO2.size() == 1) {
                break;
            }
        }

        System.out.println(oxygen);
        System.out.println(CO2);

        System.out.println(Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(CO2.get(0), 2));

    }
}
