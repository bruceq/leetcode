package com.it.bruce.leetcode._63.UniquePathsII;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0},
        };
        Main main = new Main();
        System.out.println(main.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] p = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         p[i][j] = 0;
        //     }
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        p[i][j] = 1;
                    } else if (i == 0) {
                        p[i][j] = p[i][j - 1];
                    } else if (j == 0) {
                        p[i][j] = p[i - 1][j];
                    } else {
                        p[i][j] = p[i - 1][j] + p[i][j - 1];
                    }
                }
            }
        }
        return p[m - 1][n - 1];
    }
}
