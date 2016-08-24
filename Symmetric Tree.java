/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left = mirror(root.left);
        boolean result = isSameTree(root.left, root.right);
        root.left = mirror(root.left);
        return result;
    }
    private TreeNode mirror(TreeNode root) {
        if(root==null) return root;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        root.left = mirror(root.left);
        root.right = mirror(root.right);
        return root;
    }
    private boolean isSameTree(TreeNode a, TreeNode b) {
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
