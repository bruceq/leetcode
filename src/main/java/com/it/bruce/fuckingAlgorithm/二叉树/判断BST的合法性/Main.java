package com.it.bruce.fuckingAlgorithm.二叉树.判断BST的合法性;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
