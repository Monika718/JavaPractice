package com.codingPractice;


public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode lmax = maxNode(root.left);
            TreeNode rmax = maxNode(root.right);
            if (lmax != null && lmax.val > root.val) {
                root = lmax;
            }
            if (rmax != null && rmax.val > root.val) {
                root = rmax;
            }
        }
        return root;
    }

}

