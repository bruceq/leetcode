package com.it.bruce.leetcode._64.MinimumPathSum;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        Main main = new Main();
        System.out.println(main.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minPath = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    minPath[i][j] = grid[0][0];
                } else if (i == 0) {
                    minPath[i][j] = minPath[0][j - 1] + grid[i][j];
                } else if (j == 0) {
                    minPath[i][j] = minPath[i - 1][0] + grid[i][j];
                } else {
                    minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
                }
            }
        }
        return minPath[m - 1][n - 1];
    }
}
