package com.adventofcode.day.four;

public class Board {

    public Element[][] board;
    public boolean active;

    public Board(Integer[][] board) {
        active = true;
        Element[][] e = new Element[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                e[i][j] = new Element();
                e[i][j].value = board[i][j];
                e[i][j].marked = false;
            }
        }
        this.board = e;
    }

    public int makeMove(int value) {
        if (active) {
        for (Element[] elements : board) {
            for (int j = 0; j < board.length; j++) {
                if (elements[j].value == value) {
                    elements[j].marked = true;
                    int win = checkIfWin();

                    if (win > 0) {
                        active = false;
                        return win * value;
                    }
                }
            }
        }
        }
        return 0;
    }

    private int checkIfWin() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].marked && board[i][1].marked && board[i][2].marked && board[i][3].marked && board[i][4].marked) {
                return calculateValue();
            }
            if (board[0][i].marked && board[1][i].marked && board[2][i].marked && board[3][i].marked && board[4][i].marked) {
                return calculateValue();
            }
        }
        return 0;
    }

    private int calculateValue() {
        int value = 0;

        for (Element[] elements : board) {
            for (int j = 0; j < board.length; j++) {
                if (!elements[j].marked) {
                    value += elements[j].value;
                }
            }

        }

        return value;
    }

}
