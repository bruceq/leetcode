package com.it.bruce.leetcode._236.二叉树的最近公共祖先;

import com.it.bruce.leetcode.华为.模拟八.Problem3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(1);
        TreeNode ll = new TreeNode(6);
        TreeNode lr = new TreeNode(2);
        TreeNode rl = new TreeNode(0);
        TreeNode rr = new TreeNode(8);
        TreeNode lrl = new TreeNode(7);
        TreeNode lrr = new TreeNode(4);
//        TreeNode lll = new TreeNode(7);
//        TreeNode llr = new TreeNode(2);
//        TreeNode rrl = new TreeNode(5);
//        TreeNode rrr = new TreeNode(1);
        Main main = new Main();
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        lr.left = lrl;
        lr.right = lrr;
//        ll.left = lll;
//        ll.right = llr;
//        rr.left = rrl;
//        rr.right = rrr;
        main.lowestCommonAncestor(root, l, lrr);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), p, q, root);
        TreeNode ancestor = null;
        for (int i = 0; i < list.get(0).size(); i++) {
            if (i < list.get(1).size()) {
                int i1 = list.get(0).get(i).val;
                int i2 = list.get(1).get(i).val;
                if (i1 == i2) {
                    ancestor = list.get(0).get(i);
                }
            }
        }
        return ancestor;
    }

    private void dfs(List<List<TreeNode>> list, List<TreeNode> tempList, TreeNode p, TreeNode q, TreeNode node) {
        if (node == null) {
            return;
        }
        tempList.add(node);
        if (tempList.get(tempList.size() - 1).equals(q) || tempList.get(tempList.size() - 1).equals(p) || list.size() == 2) {
            list.add(new ArrayList<>(tempList));
        }
        if (node.left != null) {
            dfs(list, tempList, p, q, node.left);
            tempList.remove(tempList.size() - 1);
        }
        if (node.right != null) {
            dfs(list, tempList, p, q, node.right);
            tempList.remove(tempList.size() - 1);
        }
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
