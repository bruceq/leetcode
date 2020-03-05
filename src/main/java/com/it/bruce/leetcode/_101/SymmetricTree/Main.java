package com.it.bruce.leetcode._101.SymmetricTree;

import java.util.ArrayList;
import java.util.List;

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
        Main.TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(main.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
