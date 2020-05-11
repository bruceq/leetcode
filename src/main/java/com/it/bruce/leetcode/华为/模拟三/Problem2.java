package com.it.bruce.leetcode.华为.模拟三;

import com.it.bruce.leetcode.华为.模拟一.Problem;

/**
 * 给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * 输出: 3
 * 提示: 给定矩阵中的元素数量不会超过 10,000。
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 main = new Problem2();
        int[][] M = {
                {0, 1, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(main.longestLine(M));
    }

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int ans = 0;
        int[] horizontal = new int[M[0].length];
        int[] vertical = new int[M[0].length];
        int[] diagonal = new int[M[0].length];
        int[] antidiagonal = new int[M[0].length];
        for (int i = 0; i < M.length; ++i) {
            int[] vertical_new = new int[M[0].length];
            int[] diagonal_new = new int[M[0].length];
            int[] antidiagonal_new = new int[M[0].length];
            for (int j = 0; j != M[0].length; ++j) {
                if (M[i][j] == 0) {
                    horizontal[j] = 0;
                    vertical_new[j] = 0;
                    diagonal_new[j] = 0;
                    antidiagonal_new[j] = 0;
                } else {
                    horizontal[j] = j > 0 ? horizontal[j - 1] + 1 : 1;
                    vertical_new[j] = i > 0 ? vertical[j] + 1 : 1;
                    diagonal_new[j] = i > 0 && j > 0 ? diagonal[j - 1] + 1 : 1;
                    antidiagonal_new[j] = i > 0 && j < M[0].length - 1 ? antidiagonal[j + 1] + 1 : 1;
                    ans = Math.max(ans, horizontal[j]);
                    ans = Math.max(ans, vertical_new[j]);
                    ans = Math.max(ans, diagonal_new[j]);
                    ans = Math.max(ans, antidiagonal_new[j]);
                }
            }
            vertical = vertical_new;
            diagonal = diagonal_new;
            antidiagonal = antidiagonal_new;
        }
        return ans;
    }

}
