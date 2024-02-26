package laicode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructTree {
    public static TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // Write your solution here
        if(inOrder==null || levelOrder == null || inOrder.length == 0 || inOrder.length != levelOrder.length){
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        int index = 0;
        for(;index<inOrder.length;index++){
            if(inOrder[index] == root.key){
                break;
            }
        }
        root.left = helper(inOrder, levelOrder, 0, index-1,1);
        root.right = helper(inOrder, levelOrder, index+1,inOrder.length-1,1);
        return root;
    }

    private static TreeNode helper(int[] inOrder,int[] levelOrder, int left, int right, int orderIndex){
        if(left > right){
            return null;
        }
        else if(left == right){
            return new TreeNode(inOrder[left]);
        }
        int index = 0;
        boolean found = false;
        TreeNode root = null;
        for(int i = orderIndex;i<levelOrder.length;i++){
            int value= levelOrder[i];
            for(int j = left;j<=right;j++){
                if(value == inOrder[j]){
                    found = true;
                    index = j;
                    root = new TreeNode(value);
                    break;
                }
            }
            if(found){
                break;
            }
        }
        if(root!=null){
            root.left = helper(inOrder,levelOrder,left,index-1,orderIndex+1);
            root.right = helper(inOrder,levelOrder,index+1,right,orderIndex+1);
        }
        return root;
    }
    private static void inOrderIteration(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode helper = root;

        while(!stack.isEmpty() || helper!=null) {
            if (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.pollFirst();
                System.out.println(helper.key);
                helper = helper.right;
            }
        }
    }

    public static void main(String[] args){
        int[] inOrder = {1,6,5,7,4,10,9};
        int[] levelOrder = {4,1,10,5,9,6,7};

        TreeNode root = reconstruct(inOrder,levelOrder);
        inOrderIteration(root);



    }
}
