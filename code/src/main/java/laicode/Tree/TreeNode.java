package laicode.Tree;

import java.util.Objects;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return key == treeNode.key && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, left, right);
    }

    public TreeNode(int e){
        this.key = e;
    }
}
