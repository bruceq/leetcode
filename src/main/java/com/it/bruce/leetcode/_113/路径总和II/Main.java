package com.it.bruce.leetcode._113.路径总和II;

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
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node42;
        node11.left = node7;
        node11.right = node2;
        node42.right = node1;
        node42.left = node5;
        Main main = new Main();
        System.out.println(main.pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, sum, list, new ArrayList<>());
        return list;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> list, List<Integer> tempList) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        tempList.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            list.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        dfs(node.left, sum, list, tempList);
        dfs(node.right, sum, list, tempList);
        tempList.remove(tempList.size() - 1);
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