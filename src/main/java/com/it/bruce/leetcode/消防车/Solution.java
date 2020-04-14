package com.it.bruce.leetcode.消防车;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        int[][] matrix = {
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        System.out.println(main.solve(matrix, 0, 0, 0, 3));
    }

    public int solve(int[][] matrix, int startX, int startY, int endX, int endY) {
        List<List<int[]>> list = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        backtrack(matrix, startX, startY, endX, endY, list, new ArrayList<>(), visited);
        int path = Integer.MAX_VALUE;
        for (List<int[]> l : list) {
            int barrier = 0;
            boolean isOK = true;
            for (int[] i : l) {
                if (matrix[i[0]][i[1]] == 1) {
                    barrier++;
                }
                if (barrier > 1) {
                    isOK = false;
                    break;
                }
            }
            if (isOK) {
                path = l.size() - 1 < path ? l.size() - 1 : path;
            }
        }
        return path;
    }

    private void backtrack(int[][] matrix, int startX, int startY, int endX, int endY, List<List<int[]>> list, List<int[]> tempList, int[][] visited) {
        if (!tempList.isEmpty() && tempList.get(tempList.size() - 1)[0] == endX && tempList.get(tempList.size() - 1)[1] == endY) {
            list.add(new ArrayList<>(tempList));
        }
        tempList.add(new int[]{startX, startY});
        visited[startX][startY] = 1;
        if (startX - 1 >= 0 && visited[startX - 1][startY] == 0) {
            backtrack(matrix, startX - 1, startY, endX, endY, list, tempList, visited);
        }
        if (startY - 1 >= 0 && visited[startX][startY - 1] == 0) {
            backtrack(matrix, startX, startY - 1, endX, endY, list, tempList, visited);
        }
        if (startX + 1 < matrix.length && visited[startX + 1][startY] == 0) {
            backtrack(matrix, startX + 1, startY, endX, endY, list, tempList, visited);
        }
        if (startY + 1 < matrix[0].length && visited[startX][startY + 1] == 0) {
            backtrack(matrix, startX, startY + 1, endX, endY, list, tempList, visited);
        }
        tempList.remove(tempList.size() - 1);
        visited[startX][startY] = 0;
    }

}
