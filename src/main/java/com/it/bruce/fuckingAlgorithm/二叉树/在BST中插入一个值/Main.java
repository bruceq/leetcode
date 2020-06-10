package com.it.bruce.fuckingAlgorithm.二叉树.在BST中插入一个值;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
