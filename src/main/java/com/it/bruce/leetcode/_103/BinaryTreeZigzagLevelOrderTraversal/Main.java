package com.it.bruce.leetcode._103.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(50);
        root.right.left.right = new TreeNode(70);
        System.out.println(main.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> list = res.get(i);
                Collections.reverse(list);
            }
        }
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }
}
