package com.it.bruce.leetcode._289.生命游戏;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        main.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 0 || board[0] == null) {
            return;
        }
        int[][] tem = new int[m + 2][n + 2];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || i == m + 1 || j == 0 || j == n + 1) {
                    tem[i][j] = 0;
                } else {
                    tem[i][j] = board[i - 1][j - 1];
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (board[i - 1][j - 1] == 1 && (check(tem, i, j) < 2 || check(tem, i, j) > 3)) {
                    board[i - 1][j - 1] = 0;
                } else if (board[i - 1][j - 1] == 1 && (check(tem, i, j) == 2 || check(tem, i, j) == 3)) {
                    board[i - 1][j - 1] = 1;
                } else if (board[i - 1][j - 1] == 0 && check(tem, i, j) == 3) {
                    board[i - 1][j - 1] = 1;
                }
            }
        }
    }

    private int check(int[][] tem, int i, int j) {
        int res = 0;
        if (tem[i - 1][j] == 1) {
            res++;
        }
        if (tem[i + 1][j] == 1) {
            res++;
        }
        if (tem[i][j - 1] == 1) {
            res++;
        }
        if (tem[i][j + 1] == 1) {
            res++;
        }
        if (tem[i - 1][j - 1] == 1) {
            res++;
        }
        if (tem[i - 1][j + 1] == 1) {
            res++;
        }
        if (tem[i + 1][j - 1] == 1) {
            res++;
        }
        if (tem[i + 1][j + 1] == 1) {
            res++;
        }
        return res;
    }
}
