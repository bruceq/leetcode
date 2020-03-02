package com.it.bruce.leetcode._94.BinaryTreeInorderTraversal;

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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(main.inorderTraversal(root));
        String a = "";
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = inorderTraversal(root.left);
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
