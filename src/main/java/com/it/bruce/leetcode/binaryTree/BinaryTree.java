package com.it.bruce.leetcode.binaryTree;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        System.out.print("前序遍历：");
        binaryTree.preOrderTraverse(binaryTree.init());
        System.out.println();
        System.out.print("中序遍历：");
        binaryTree.InOrderTraverse(binaryTree.init());
        System.out.println();
        System.out.print("后序遍历：");
        binaryTree.PostOrderTraverse(binaryTree.init());
    }

    private BinaryTreeNode init() {
        BinaryTreeNode root = new BinaryTreeNode("a");
        BinaryTreeNode nodeB = new BinaryTreeNode("b");
        BinaryTreeNode nodeC = new BinaryTreeNode("c");
        root.setLchild(nodeB);
        root.setRchild(nodeC);
        BinaryTreeNode nodeD = new BinaryTreeNode("d");
        BinaryTreeNode nodeE = new BinaryTreeNode("e");
        nodeB.setLchild(nodeD);
        nodeB.setRchild(nodeE);
        BinaryTreeNode nodeH = new BinaryTreeNode("h");
        nodeD.setLchild(nodeH);
        BinaryTreeNode nodeK = new BinaryTreeNode("k");
        nodeH.setRchild(nodeK);
        BinaryTreeNode nodeF = new BinaryTreeNode("f");
        BinaryTreeNode nodeG = new BinaryTreeNode("g");
        nodeC.setLchild(nodeF);
        nodeC.setRchild(nodeG);
        BinaryTreeNode nodeI = new BinaryTreeNode("i");
        nodeF.setLchild(nodeI);
        BinaryTreeNode nodeJ = new BinaryTreeNode("j");
        nodeG.setRchild(nodeJ);
        return root;
    }

    /**
     * 前序遍历
     *
     * @param binaryTreeNode
     */
    private void preOrderTraverse(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        System.out.print(binaryTreeNode.getData() + " ");
        preOrderTraverse(binaryTreeNode.getLchild());
        preOrderTraverse(binaryTreeNode.getRchild());
    }

    /**
     * 中序遍历
     *
     * @param binaryTreeNode
     */
    private void InOrderTraverse(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        InOrderTraverse(binaryTreeNode.getLchild());
        System.out.print(binaryTreeNode.getData() + " ");
        InOrderTraverse(binaryTreeNode.getRchild());
    }

    /**
     * 后序遍历
     *
     * @param binaryTreeNode
     */
    private void PostOrderTraverse(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        PostOrderTraverse(binaryTreeNode.getLchild());
        PostOrderTraverse(binaryTreeNode.getRchild());
        System.out.print(binaryTreeNode.getData() + " ");
    }

    class BinaryTreeNode {
        private String data;
        private BinaryTreeNode lchild;
        private BinaryTreeNode rchild;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public BinaryTreeNode getLchild() {
            return lchild;
        }

        public void setLchild(BinaryTreeNode lchild) {
            this.lchild = lchild;
        }

        public BinaryTreeNode getRchild() {
            return rchild;
        }

        public void setRchild(BinaryTreeNode rchild) {
            this.rchild = rchild;
        }
    }
}
