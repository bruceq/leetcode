package com.it.bruce.leetcode._112.路径总和;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(3);
        TreeNode rootll = new TreeNode(4);
        TreeNode rootlr = new TreeNode(5);
        TreeNode rootrr = new TreeNode(6);
        root.left = rootl;
        root.right = rootr;
        rootl.left = rootll;
        rootl.right = rootlr;
        rootr.right = rootrr;
        Solution main = new Solution();
        System.out.println(main.hasPathSum(root, 7));

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }
//    boolean res = false;
//
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        int tem = 0;
//        dfs(root, sum, tem);
//        return res;
//    }
//
//    private void dfs(TreeNode node, int sum, int tem) {
//        tem += node.val;
//        if (tem == sum && node.left == null && node.right == null) {
//            res = true;
//        }
//        if (node.left != null) {
//            dfs(node.left, sum, tem);
//        }
//        if (node.right != null) {
//            dfs(node.right, sum, tem);
//        }
//    }

}
