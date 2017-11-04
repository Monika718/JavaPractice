package com.dataStructures;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    BinaryTreeNode(int x) {
        value = x;
        left = null;
        right = null;
    }

    BinaryTreeNode(int x, BinaryTreeNode l, BinaryTreeNode r) {
        value = x;
        left = l;
        right = r;
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