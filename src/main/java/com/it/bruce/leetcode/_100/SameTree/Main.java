package com.it.bruce.leetcode._100.SameTree;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        System.out.println(main.isSameTree(root, root1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

}
