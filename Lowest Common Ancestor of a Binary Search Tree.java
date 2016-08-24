/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null) return q;
        if(q==null) return p;
        if(root==null) return null;
        if(p.val>q.val) return lowestCommonAncestor(root, q, p);
        
        if(root.val<p.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val==p.val || root.val==q.val || (root.val>p.val && root.val < q.val)) return root;
        else return lowestCommonAncestor(root.left, p, q);
    }
}
