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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    private int height(TreeNode root) {
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
/*
T(N) = 2T(N/2)+O(N)
O(nlog(n))
*/
