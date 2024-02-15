import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {

    public TreeNode delete(TreeNode root, int target){
        return root;


    }

    public void preOrderIteration(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pollFirst();
            System.out.println(cur.key);
            if(cur.right != null){
                stack.offerFirst(cur.right);
            }
            if(cur.left != null){
                stack.offerFirst(cur.left);
            }

        }
    }


    public void inOrderIteration(TreeNode root){
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

    public void postOrderIteration(TreeNode root){
        if(root == null){
            return;
        }

    }


}
