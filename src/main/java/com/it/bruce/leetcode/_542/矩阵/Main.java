package com.it.bruce.leetcode._542.矩阵;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private int[][] position = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

//    public int[][] updateMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                Queue<int[]> queue = new LinkedList<>();
//                Queue<int[]> subQueue = new LinkedList<>();
//                queue.add(new int[]{i, j});
//                while (!queue.isEmpty()) {
//                    int[] poll = queue.poll();
//                    for (int[] pos : position) {
//                        int x = poll[0] + pos[0];
//                        int y = poll[1] + pos[1];
//                        if (x < 0 || y < 0 || x > matrix.length || y > matrix[0].length) {
//                            continue;
//                        }
//                        subQueue.add(new int[]{x, y});
//                    }
//
//                }
//            }
//        }
//    }
}
