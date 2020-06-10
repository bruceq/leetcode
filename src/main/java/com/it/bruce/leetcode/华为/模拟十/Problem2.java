package com.it.bruce.leetcode.华为.模拟十;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Problem2 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode rootl = new TreeNode(4);
//        TreeNode rootr = new TreeNode(8);
//        TreeNode rootll = new TreeNode(11);
//        TreeNode rootlll = new TreeNode(7);
//        TreeNode rootllr = new TreeNode(2);
//        TreeNode rootrl = new TreeNode(13);
//        TreeNode rootrr = new TreeNode(4);
//        TreeNode rootrrl = new TreeNode(5);
//        TreeNode rootrrr = new TreeNode(1);
//
//
//        root.left = rootl;
//        root.right = rootr;
//        rootl.left = rootll;
//        rootll.left = rootlll;
//        rootll.right = rootllr;
//        rootr.left = rootrl;
//        rootr.right = rootrr;
//        rootrr.left = rootrrl;
//        rootrr.right = rootrrr;

        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        root.left = rootl;
        Problem2 main = new Problem2();
        main.pathSum(root, 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), root, sum);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, TreeNode root, int sum) {
        if (root != null) {
            tempList.add(root.val);
        }
        if (sum(tempList) == sum && root.left == null && root.right == null) {
            list.add(new ArrayList<>(tempList));
        }
        if (root.left != null) {
            dfs(list, tempList, root.left, sum);
        }
        if (root.right != null) {
            dfs(list, tempList, root.right, sum);
        }
        tempList.remove(tempList.size() - 1);
    }

    private int sum(List<Integer> tempList) {
        int sum = 0;
        for (int i : tempList) {
            sum += i;
        }
        return sum;
    }
}
