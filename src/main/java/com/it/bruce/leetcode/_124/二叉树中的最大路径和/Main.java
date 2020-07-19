package com.it.bruce.leetcode._124.二叉树中的最大路径和;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        TreeNode root = new TreeNode(1);
//        TreeNode rootl = new TreeNode(2);
//        TreeNode rootr = new TreeNode(3);
//        root.left = rootl;
//        root.right = rootr;
//        TreeNode root = new TreeNode(-10);
//        TreeNode rootl = new TreeNode(9);
//        TreeNode rootr = new TreeNode(20);
//        TreeNode rootrl = new TreeNode(15);
//        TreeNode rootrr = new TreeNode(7);
//        root.left = rootl;
//        root.right = rootr;
//        rootr.left = rootrl;
//        rootr.right = rootrr;
        TreeNode root = new TreeNode(2);
        TreeNode rootl = new TreeNode(-1);
        root.left = rootl;
        System.out.println(main.maxPathSum(root));
    }

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxValue;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null)
            return 0;
        //左子节点的值
        int left = maxPathSumHelper(root.left);
        //右子节点的值
        int right = maxPathSumHelper(root.right);
        //第4种情况
        int cur = root.val + Math.max(0, left) + Math.max(0, right);
        //第1,2,3三种情况,返回当前值加上左右子节点的最大值即可，如果左右子节点都
        //小于0，还不如不选
        int res = root.val + Math.max(0, Math.max(left, right));
        //记录最大value值
        maxValue = Math.max(maxValue, Math.max(cur, res));
        //第1,2,3种情况还可以再计算，所以返回的是res
        return res;
    }

//    public int maxPathSum(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        dfs(list, root);
//        int res = Integer.MIN_VALUE;
//        for (int i : list) {
//            if (i > res) {
//                res = i;
//            }
//        }
//        return res;
//    }
//
//    private void dfs(List<Integer> list, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        int val = node.val;
//        list.add(sum(val, node));
//        dfs(list, node.left);
//        dfs(list, node.right);
//    }
//
//    private int sum(int val, TreeNode node) {
//        if (node == null) {
//            return val;
//        }
//        if (node.left != null) {
//            val += node.left.val;
//        }
//        if (node.right != null) {
//            val += node.right.val;
//        }
//        sum(val, node.left);
//        sum(val, node.right);
//        return val;
//    }
}
