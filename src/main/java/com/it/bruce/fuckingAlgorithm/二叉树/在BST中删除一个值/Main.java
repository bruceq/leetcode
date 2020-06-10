package com.it.bruce.fuckingAlgorithm.二叉树.在BST中删除一个值;

import com.it.bruce.fuckingAlgorithm.二叉树.TreeNode;

public class Main {

    private TreeNode deleteBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMinNode(root);
            root.val = minNode.val;
            root.right = deleteBST(root.right, minNode.val);
        }
        if (root.val > val) {
            root.left = deleteBST(root.left, val);
        }
        if (root.val < val) {
            root.right = deleteBST(root.right, val);
        }
        return root;
    }

    private TreeNode getMinNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
