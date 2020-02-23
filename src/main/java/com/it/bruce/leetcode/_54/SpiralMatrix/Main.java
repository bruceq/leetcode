package com.it.bruce.leetcode._54.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };
        System.out.println(main.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // 利用动态规划
        // 记录一个m*n的矩阵，存放当前点是否走过，执行以下逻辑
        // if(!visit[m+1][n]) visit[m+1][n]=true;
        // else if(!visit[m][n+1]) visit[m][n+1]=true;
        // else if(!visit[m-1][n]) visit[m-1][n]=true;
        // else if(!visit[m][n-1]) visit[m][n-1]=true;
        // else return;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visit[i][j] = false;
            }
        }
        visit[0][0] = true;
        list.add(matrix[0][0]);
        visited(list, visit, matrix, 0, 0);
        return list;
    }

    private void visited(List<Integer> list, boolean[][] visit, int[][] matrix, int m, int n) {
        if ((n + 1) < (matrix[0].length) && !visit[m][n + 1]) {// right
            if ((m - 1) >= 0 && !visit[m - 1][n]) {
                visit[m - 1][n] = true;
                list.add(matrix[m - 1][n]);
                visited(list, visit, matrix, m - 1, n);
            } else {
                visit[m][n + 1] = true;
                list.add(matrix[m][n + 1]);
                visited(list, visit, matrix, m, n + 1);
            }
        } else if ((m + 1) < matrix.length && !visit[m + 1][n]) {// down
            visit[m + 1][n] = true;
            list.add(matrix[m + 1][n]);
            visited(list, visit, matrix, m + 1, n);
        } else if ((n - 1) >= 0 && !visit[m][n - 1]) { // up
            visit[m][n - 1] = true;
            list.add(matrix[m][n - 1]);
            visited(list, visit, matrix, m, n - 1);
        } else if ((m - 1) >= 0 && !visit[m - 1][n]) { // left
            visit[m - 1][n] = true;
            list.add(matrix[m - 1][n]);
            visited(list, visit, matrix, m - 1, n);
        } else return;
    }
}
