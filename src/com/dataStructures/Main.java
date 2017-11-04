package com.dataStructures;

import static java.sql.Types.NULL;

public class Main {
    public static void createTree(int[] treeArray) {
        BinaryTree tree = new BinaryTree(treeArray[0]);
        for (int i = 1; i < treeArray.length; i++) {
            BinaryTreeNode parent = new BinaryTreeNode(treeArray[i - 1]);
            BinaryTreeNode child = new BinaryTreeNode(treeArray[i]);
            if ( i % 2 == 0) {
                tree.addTreeNode(parent, child, "right");
            } else {
                tree.addTreeNode(parent, child, "left");
            }
        }
    }

    public static void printTree(BinaryTree tree) {
        int[] result = new int[10];
    }

    public static void main(String[] args) {
        // write your code here
        int[] treeArray = {1, 2, 3, NULL, 4, 5};
        BinaryTree tree = new BinaryTree(treeArray[0]);
        createTree(treeArray);
        System.out.println(tree);
    }
}