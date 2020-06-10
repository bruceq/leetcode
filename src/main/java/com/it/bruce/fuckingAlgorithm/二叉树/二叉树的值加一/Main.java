package com.it.bruce.fuckingAlgorithm.二叉树.二叉树的值加一;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootll = new TreeNode(3);
        TreeNode rootr = new TreeNode(4);
        root.left = rootl;
        rootl.left = rootll;
        root.right = rootr;
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + 1 + " ");
        dfs(root.left);
        dfs(root.right);
    }
}
