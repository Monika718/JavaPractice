package com.codingPractice;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

}

