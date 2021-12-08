package com.adventofcode.day.four;

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
                        Path.of("C:\\Users\\wkami\\IdeaProjects\\advent-of-code-2021\\src\\main\\resources\\day_four\\input.txt"));

        List<Integer> moves = Arrays.stream(lines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());

        lines.remove(0);

        List<Board> boards = new ArrayList<>();

        int i = 0;
        Integer[][] board = new Integer[5][5];
        for (String s : lines) {
            if (!s.equals("")) {
                if (i < 5) {
                    String[] split = s.split("\\s+");
                    System.out.println(Arrays.toString(split));
                    if (split[0].equals("")) {
                        for (int j = 0; j < split.length - 1; j++) {
                            board[i][j] = Integer.parseInt(split[j + 1]);
                        }
                    } else {
                        for (int j = 0; j < split.length; j++) {
                            board[i][j] = Integer.parseInt(split[j]);
                        }
                    }
                    ++i;
                }
            }
            if (i == 5) {
                boards.add(new Board(board));
                board = new Integer[5][5];
                i = 0;
            }
        }

        for (int m : moves) {
            for (Board b : boards) {
                int result = b.makeMove(m);
                if (result > 0) {
                    System.out.println(result);
                }
            }
        }

    }
}
