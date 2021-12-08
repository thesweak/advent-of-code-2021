package com.adventofcode.day.eight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartOne {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_eight\\input.txt"));

        Map<Integer, String> map;

        int counter = 0;

        for (String line : lines) {
            map = deserialize(line);
            System.out.println(map);
            int temp = 0;
            int digit = 0;
            String sub = line.substring(line.indexOf("|") + 2);

            String[] s = sub.split(" ");
            System.out.println(Arrays.toString(s));
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() == 7) {
                    digit = 8;
                } else if (s[i].length() == 2) {
                    digit = 1;
                } else if (s[i].length() == 3) {
                    digit = 7;
                } else if (s[i].length() == 4) {
                    digit = 4;
                } else {
                    if (s[i].length() == 5 && s[i].contains(String.valueOf(map.get(3).charAt(0))) && s[i].contains(String.valueOf(map.get(3).charAt(1))) && s[i].contains(String.valueOf(map.get(3).charAt(2))) && s[i].contains(String.valueOf(map.get(3).charAt(3))) && s[i].contains(String.valueOf(map.get(3).charAt(4)))) {
                        digit = 3;
                    } else if (s[i].length() == 5 && s[i].contains(String.valueOf(map.get(5).charAt(0))) && s[i].contains(String.valueOf(map.get(5).charAt(1))) && s[i].contains(String.valueOf(map.get(5).charAt(2))) && s[i].contains(String.valueOf(map.get(5).charAt(3))) && s[i].contains(String.valueOf(map.get(5).charAt(4)))) {
                        digit = 5;
                    } else if (s[i].length() == 5 && s[i].contains(String.valueOf(map.get(2).charAt(0))) && s[i].contains(String.valueOf(map.get(2).charAt(1))) && s[i].contains(String.valueOf(map.get(2).charAt(2))) && s[i].contains(String.valueOf(map.get(2).charAt(3))) && s[i].contains(String.valueOf(map.get(2).charAt(4)))) {
                        digit = 2;
                    } else if (s[i].length() == 6 && s[i].contains(String.valueOf(map.get(9).charAt(0))) && s[i].contains(String.valueOf(map.get(9).charAt(1))) && s[i].contains(String.valueOf(map.get(9).charAt(2))) && s[i].contains(String.valueOf(map.get(9).charAt(3))) && s[i].contains(String.valueOf(map.get(9).charAt(4))) && s[i].contains(String.valueOf(map.get(9).charAt(5)))) {
                        digit = 9;
                    } else if (s[i].length() == 6 && s[i].contains(String.valueOf(map.get(6).charAt(0))) && s[i].contains(String.valueOf(map.get(6).charAt(1))) && s[i].contains(String.valueOf(map.get(6).charAt(2))) && s[i].contains(String.valueOf(map.get(6).charAt(3))) && s[i].contains(String.valueOf(map.get(6).charAt(4))) && s[i].contains(String.valueOf(map.get(6).charAt(5)))) {
                        digit = 6;
                    } else if (s[i].length() == 6 && s[i].contains(String.valueOf(map.get(0).charAt(0))) && s[i].contains(String.valueOf(map.get(0).charAt(1))) && s[i].contains(String.valueOf(map.get(0).charAt(2))) && s[i].contains(String.valueOf(map.get(0).charAt(3))) && s[i].contains(String.valueOf(map.get(0).charAt(4))) && s[i].contains(String.valueOf(map.get(0).charAt(5)))) {
                        digit = 0;
                    }

                }

                System.out.println(digit);
                if (i == 0) {
                    digit *= 1000;
                } else if (i == 1) {
                    digit *= 100;
                } else if (i == 2) {
                    digit *= 10;
                }

                temp += digit;
            }

            counter += temp;
        }


        System.out.println(counter);

    }

    private static Map<Integer, String> deserialize(String line) {
        Map<Integer, String> map = new HashMap<>();

        String sub = line.substring(0, line.indexOf("|"));

        String[] s = sub.split(" ");

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 7) {
                map.put(8, s[i]);
            } else if (s[i].length() == 2) {
                map.put(1, s[i]);
            } else if (s[i].length() == 3) {
                map.put(7, s[i]);
            } else if (s[i].length() == 4) {
                map.put(4, s[i]);
            }
        }

        String four = "";
        char[] chars = map.get(4).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.get(1).contains(String.valueOf(chars[i]))) {
                four += chars[i];
            }
        }


        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 5) {
                if (s[i].contains(String.valueOf(map.get(1).charAt(0))) && s[i].contains(String.valueOf(map.get(1).charAt(1)))) {
                    map.put(3, s[i]);
                } else if (s[i].contains(String.valueOf(four.charAt(0))) && s[i].contains(String.valueOf(four.charAt(1)))) {
                    map.put(5, s[i]);
                } else {
                    map.put(2, s[i]);
                }
            }
        }

        char[] chars1 = map.get(5).toCharArray();
        char[] chars2 = map.get(2).toCharArray();
        String s1 = "abcdefg";
        String mid = "";
            for (int j = 0; j < chars1.length; j++) {
                for (int k = 0; k < chars2.length; k++) {
                    if (String.valueOf(chars1[j]).equals(String.valueOf(chars2[k])) && map.get(4).contains(String.valueOf(chars1[j])) && map.get(4).contains(String.valueOf(chars2[k]))) {
                        mid = String.valueOf(chars1[j]);
                    }
                }
        }

        char[] chars3 = map.get(1).toCharArray();
        String left = "";
        for (int i = 0; i < chars3.length; i++) {
            if (!map.get(5).contains(String.valueOf(chars3[i]))) {
                left = String.valueOf(chars3[i]);
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 6) {
                if (!s[i].contains(mid)) {
                    map.put(0, s[i]);
                } else if (!s[i].contains(left)) {
                    map.put(6, s[i]);
                } else {
                    map.put(9, s[i]);
                }
            }
        }

        return map;
    }
}
