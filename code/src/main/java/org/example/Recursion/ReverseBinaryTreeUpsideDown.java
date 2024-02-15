package org.example.Recursion;

public class ReverseBinaryTreeUpsideDown {
    //recursive
    public static TreeNode reverseRecursive(TreeNode root) {
        // Write your solution here
        if(root == null ||root.left == null){
            return root;
        }
        TreeNode newRoot = reverseRecursive(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    // iterative
    public static TreeNode reverseIterative(TreeNode root) {
        // Write your solution here
        TreeNode prev = null;
        TreeNode prevRight = null;
        while(root!=null){
            TreeNode next = root.left;
            TreeNode right = root.right;
            root.right = prevRight;
            root.left = prev;
            prevRight = right;
            prev = root;
            root=next;
        }
        return prev;
    }
}
