package com.it.bruce.leetcode.华为.模拟十六;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Problem1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(3);
        TreeNode rootll = new TreeNode(4);
        TreeNode rootlr = new TreeNode(5);
        TreeNode rootrl = new TreeNode(6);
        TreeNode rootrr = new TreeNode(7);
        root.left = rootl;
        root.right = rootr;
        rootl.left = rootll;
        rootl.right = rootlr;
        rootr.left = rootrl;
        rootr.right = rootrr;
        Problem1 main = new Problem1();
        main.invertTree(root);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
