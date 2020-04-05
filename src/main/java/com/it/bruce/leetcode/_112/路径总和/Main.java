package com.it.bruce.leetcode._112.路径总和;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node42;
        node11.left = node7;
        node11.right = node2;
        node42.right = node1;
        Main main = new Main();
        System.out.println(main.hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        System.out.print(root.val + " ");
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}