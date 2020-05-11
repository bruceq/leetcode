package com.it.bruce.leetcode.华为.模拟七;

import java.util.List;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class Problem3 {
//    public List<Integer> largestValues(TreeNode root) {
//
//    }
    public static class TreeNode {
        int val;
        Problem1.TreeNode left;
        Problem1.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
