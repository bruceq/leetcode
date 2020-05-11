package com.it.bruce.leetcode._130.被围绕的区域;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'O'},
        };
//        char[][] board = {
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//        };
        Solution main = new Solution();
        main.solve(board);
        System.out.println();
    }

    private int[][] position = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void solve(char[][] board) {
        List<int[]> list = new ArrayList<>();
        List<int[]> listNot = new ArrayList<>();
        preDraw(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, list, listNot);
                    if (listNot.isEmpty()) {
                        printNot(board, list);
                    } else {
                        print(board, list);
                    }
                    list.clear();
                    listNot.clear();
                }
            }
        }
        postDraw(board);
    }

    private void postDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void preDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    board[i][j] = 'B';
                }
            }
        }
    }

    private void print(char[][] board, List<int[]> list) {
        for (int[] ints : list) {
            board[ints[0]][ints[1]] = 'X';
        }
    }

    private void printNot(char[][] board, List<int[]> list) {
        for (int[] ints : list) {
            board[ints[0]][ints[1]] = 'O';
        }
    }

    private void dfs(char[][] board, int i, int j, List<int[]> list, List<int[]> listNot) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'B') {
            listNot.clear();
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            list.add(new int[]{i, j});
            listNot.add(new int[]{i, j});
            for (int[] pos : position) {
                dfs(board, i + pos[0], j + pos[1], list, listNot);
            }
        }
    }
}
