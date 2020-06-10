package com.it.bruce.leetcode._101.对称二叉树;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(2);
        TreeNode rootlr = new TreeNode(3);
        TreeNode rootrr = new TreeNode(3);
        root.left = rootl;
        root.right = rootr;
        rootl.right = rootlr;
        rootr.right = rootrr;
        Main main = new Main();
        System.out.println(main.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}