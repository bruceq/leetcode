package com.it.bruce.leetcode._74.Searcha2DMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = {{}
        };
        System.out.println(main.searchMatrix(matrix, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            list.add(matrix[i][0]);
        }
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (target < list.get(i)) {
                index = i - 1;
                break;
            } else if (i == list.size() - 1 && target >= list.get(i)) {
                index = i;
            }
        }
        boolean result = false;
        if (index < 0) return result;
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] == target) result = true;
        }
        return result;
    }
}
