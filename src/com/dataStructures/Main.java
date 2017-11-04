package com.dataStructures;

public class Main {

    public static void addTreeNode(BinaryTreeNode parent, BinaryTreeNode child, String direction) {
        if (direction == "left") {
            parent.setLeft(child);
        }
        if (direction == "right") {
            parent.setRight(child);
        }
    }

    public static BinaryTreeNode createTree() {
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(2,null, a);
        BinaryTreeNode c = new BinaryTreeNode(3, b, null);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(5);
        BinaryTreeNode f = new BinaryTreeNode(6, d, e);
        BinaryTreeNode g = new BinaryTreeNode(7, c, f);
        return g;
    }

    public static void visit(BinaryTreeNode node) {
        System.out.println("Treenode Value: " + node.getValue());
    }

    public static void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }

    public static void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
        }
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Preorder:");
        preOrder(createTree());

        System.out.println("Inorder:");
        inOrder(createTree());

        System.out.println("Postorder:");
        postOrder(createTree());

    }
}
