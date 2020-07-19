package com.it.bruce.leetcode.华为.模拟十一;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(3);
        TreeNode rootll = new TreeNode(4);
        TreeNode rootlr = new TreeNode(5);
        root.left = rootl;
        root.right = rootr;
        rootl.left = rootll;
        rootl.right = rootlr;
        Problem1 main = new Problem1();
        main.verticalOrder(root);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root, root.left.right, root.right.left);
        return new ArrayList<>();
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    private void inOrder(TreeNode node, TreeNode nodelr, TreeNode noderl) {
        if (node == null) {
            return;
        }
        if (node.left.left.right != null || node.left.right.left != null) {
            inOrder(node.left, node.left.left.right, node.left.right.left);
        }
        if (node.right.left.right != null || node.right.right.left != null) {
            inOrder(node.right, node.right.left.right, node.right.right.left);
        }

    }

}
