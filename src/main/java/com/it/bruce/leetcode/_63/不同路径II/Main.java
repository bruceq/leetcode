package com.it.bruce.leetcode._63.不同路径II;

public class Main {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{0}};
        Main main = new Main();
        System.out.println(main.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        res[0][0] = 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        res[i][j] = 1;
                    } else if (i == 0) {
                        res[i][j] = res[i][j - 1];
                    } else if (j == 0) {
                        res[i][j] = res[i - 1][j];
                    } else {
                        res[i][j] = res[i - 1][j] + res[i][j - 1];
                    }
                }
            }
        }
        return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
//    int path = 0;
//
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        dfs(obstacleGrid, 0, 0);
//        return path;
//    }
//
//    private void dfs(int[][] obstacleGrid, int i, int j) {
//        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1 && obstacleGrid[i][j] == 0 && obstacleGrid[0][0] == 0) {
//            path++;
//        }
//        if (i + 1 < obstacleGrid.length && obstacleGrid[i + 1][j] == 0) {
//            dfs(obstacleGrid, i + 1, j);
//        }
//        if (j + 1 < obstacleGrid[0].length && obstacleGrid[i][j + 1] == 0) {
//            dfs(obstacleGrid, i, j + 1);
//        }
//    }
}
