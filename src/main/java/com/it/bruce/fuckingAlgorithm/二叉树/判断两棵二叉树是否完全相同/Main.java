package com.it.bruce.fuckingAlgorithm.二叉树.判断两棵二叉树是否完全相同;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root1l = new TreeNode(2);
        TreeNode root1ll = new TreeNode(3);
        TreeNode root1r = new TreeNode(4);
        root1.left = root1l;
        root1l.left = root1ll;
        root1.right = root1r;
        TreeNode root2 = new TreeNode(1);
        TreeNode root2l = new TreeNode(2);
        TreeNode root2ll = new TreeNode(3);
        TreeNode root2r = new TreeNode(2);
        root2.left = root2l;
        root2l.left = root2ll;
        root2.right = root2r;
        System.out.println(judge(root1, root2));
    }

    private static boolean judge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return judge(node1.left, node2.left) && judge(node1.right, node2.right);
    }
}
