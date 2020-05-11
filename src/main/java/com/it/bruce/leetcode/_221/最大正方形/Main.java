package com.it.bruce.leetcode._221.最大正方形;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        char[][] matrix = {
                {'0','0','0','1','0','1','0'},
                {'0','1','0','0','0','0','0'},
                {'0','1','0','1','0','0','1'},
                {'0','0','1','1','0','0','1'},
                {'1','1','1','1','1','1','0'},
                {'1','0','0','1','0','1','1'},
                {'0','1','0','0','1','0','1'},
                {'1','1','0','1','1','1','0'},
                {'1','0','1','0','1','0','1'},
                {'1','1','1','0','0','0','0'}
        };
        Main main = new Main();
        main.maximalSquare(matrix);
    }

    public int maximalSquare(char[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int[][] position = new int[][]{{1, 0}, {0, 1}, {1, 1}};
        int edge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    list.add(new int[]{i, j});
                    int count = 1;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        list.remove(0);
                        if (addQueue(matrix, queue, position, p)) {
                            if (list.isEmpty()) {
                                count++;
                                for (int[] q : queue) {
                                    list.add(new int[]{q[0], q[1]});
                                }
                            }
                        } else {
                            list.clear();
                            break;
                        }
                    }
                    edge = edge > count ? edge : count;
                }
            }
        }
        return edge * edge;
    }

    private boolean addQueue(char[][] matrix, Queue<int[]> queue, int[][] position, int[] p) {
        for (int[] pos : position) {
            int x = p[0] + pos[0];
            int y = p[1] + pos[1];
            if (x < matrix.length && y < matrix[0].length) {
                if (matrix[x][y] == '1') {
                    queue.add(new int[]{x, y});
                } else {
                    queue.clear();
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
