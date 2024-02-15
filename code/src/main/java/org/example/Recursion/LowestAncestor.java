package org.example.Recursion;

public class LowestAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // Write your solution here.
        if(root ==  null){
            return null;
        }
        if(root == one || root == two){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,one,two);
        TreeNode right = lowestCommonAncestor(root.right,one,two);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
}
