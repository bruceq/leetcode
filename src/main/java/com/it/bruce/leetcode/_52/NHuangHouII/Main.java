package com.it.bruce.leetcode._52.NHuangHouII;

public class Main {
    int count = 0;

    public int totalNQueens(int n) {
        String[][] arr = new String[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ".";
            }
        }
        eightqueens(0, arr, n);
        return count;
    }

    private void eightqueens(int row, String[][] arr, int n) {
        if (row == n) {
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += arr[i][j];
                }
            }
            count++;
        } else {
            String[][] new_arr = new String[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    new_arr[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                if (dangerousPositon(row, i, new_arr)) {
                    for (int j = 0; j < n; j++) {
                        new_arr[row][j] = ".";
                    }
                    new_arr[row][i] = "Q";
                    eightqueens(row + 1, new_arr, n);
                }
            }
        }
    }

    private boolean dangerousPositon(int row, int col, String[][] new_arr) {
        for (int i = row - 1; i >= 0; i--) {
            if (new_arr[i][col].equals("Q")) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (new_arr[i][j].equals("Q")) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < new_arr.length; i--, j++) {
            if (new_arr[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }
}
