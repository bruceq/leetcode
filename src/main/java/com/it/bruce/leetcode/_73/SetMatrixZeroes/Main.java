package com.it.bruce.leetcode._73.SetMatrixZeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        main.setZeroes(matrix);
        Arrays.stream(matrix).forEach(i -> {
            Arrays.stream(i).forEach(n -> System.out.print(n + " "));
            System.out.println();
        });
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i)[0];
            int n = list.get(i)[1];
            for (int x = 0; x < matrix[0].length; x++) {
                matrix[m][x] = 0;
            }
            for (int y = 0; y < matrix.length; y++) {
                matrix[y][n] = 0;
            }
        }
    }
}
