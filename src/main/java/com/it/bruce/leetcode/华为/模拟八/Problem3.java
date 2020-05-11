package com.it.bruce.leetcode.华为.模拟八;

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
public class Problem3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
//        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(-3);
//        TreeNode ll = new TreeNode(11);
//        TreeNode rl = new TreeNode(13);
//        TreeNode rr = new TreeNode(4);
//        TreeNode lll = new TreeNode(7);
//        TreeNode llr = new TreeNode(2);
//        TreeNode rrl = new TreeNode(5);
//        TreeNode rrr = new TreeNode(1);
        Problem3 main = new Problem3();
//        root.left = l;
        root.right = r;
//        l.left = ll;
//        r.left = rl;
//        r.right = rr;
//        ll.left = lll;
//        ll.right = llr;
//        rr.left = rrl;
//        rr.right = rrr;
        main.pathSum(root, -5);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), sum, root);
        return list;

    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int sum, TreeNode node) {
        if (node == null) {
            return;

        }
        tempList.add(node.val);
        if (sum(tempList) == sum && node.left == null && node.right == null) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        dfs(list, tempList, sum, node.left);
        dfs(list, tempList, sum, node.right);
        tempList.remove(tempList.size() - 1);
    }

    private int sum(List<Integer> tempList) {
        int sum = 0;
        if (tempList.isEmpty()) {
            return 0;
        } else {
            for (int i : tempList) {
                sum += i;
            }
        }
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
