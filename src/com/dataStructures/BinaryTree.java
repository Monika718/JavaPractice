package com.dataStructures;

public class BinaryTree {
    private static BinaryTreeNode root;

    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(int value) {
        root = new BinaryTreeNode(value);
        leftChild = null;
        rightChild = null;
    }

    public void addTreeNode(BinaryTreeNode parent, BinaryTreeNode child, String direction) {
        if (direction == "left") {
            parent.setLeft(child);
        }
        if (direction == "right") {
            parent.setRight(child);
        }
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }
}

class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    BinaryTreeNode(int x) {
        value = x;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}