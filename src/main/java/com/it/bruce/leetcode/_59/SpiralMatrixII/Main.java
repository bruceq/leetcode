package com.it.bruce.leetcode._59.SpiralMatrixII;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int n = 5;
        int[][] matrix = main.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public int[][] generateMatrix(int n) {
        // 利用动态规划
        // 记录一个m*n的矩阵，存放当前点是否走过，执行以下逻辑
        // if(!visit[m+1][n]) visit[m+1][n]=true;
        // else if(!visit[m][n+1]) visit[m][n+1]=true;
        // else if(!visit[m-1][n]) visit[m-1][n]=true;
        // else if(!visit[m][n-1]) visit[m][n-1]=true;
        // else return;
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return new int[][]{};
        }
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        visit[0][0] = true;
        matrix[0][0] = 1;
        visited(visit, matrix, 0, 0, 1);
        return matrix;
    }

    private void visited(boolean[][] visit, int[][] matrix, int m, int n, int i) {
        i++;
        if ((n + 1) < (matrix[0].length) && !visit[m][n + 1]) {// right
            if ((m - 1) >= 0 && !visit[m - 1][n]) {
                visit[m - 1][n] = true;
                matrix[m - 1][n] = i;
                visited(visit, matrix, m - 1, n, i);
            } else {
                visit[m][n + 1] = true;
                matrix[m][n + 1] = i;
                visited(visit, matrix, m, n + 1, i);
            }
        } else if ((m + 1) < matrix.length && !visit[m + 1][n]) {// down
            visit[m + 1][n] = true;
            matrix[m + 1][n] = i;
            visited(visit, matrix, m + 1, n, i);
        } else if ((n - 1) >= 0 && !visit[m][n - 1]) { // up
            visit[m][n - 1] = true;
            matrix[m][n - 1] = i;
            visited(visit, matrix, m, n - 1, i);
        } else if ((m - 1) >= 0 && !visit[m - 1][n]) { // left
            visit[m - 1][n] = true;
            matrix[m - 1][n] = i;
            visited(visit, matrix, m - 1, n, i);
        } else return;
    }
}
