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
    public void flatten(TreeNode root) {
        /**
         * if root==null:
         *  return
         * l=root.left
         * root.left = null
         * f(l)
         * r=root.right
         * root.right = null
         * f(r)
         * if l!=null:
         *  root.right=l
         * c=root
         * while c.right!=null:
         *  c=c.right
         * c.right=r
         */
         
         if(root==null) return;
         TreeNode l = root.left, r = root.right;
         root.left = null;
         root.right = null;
         flatten(l);
         flatten(r);
         if(l != null) root.right = l;
         TreeNode c = root;
         while(c.right != null) c = c.right; //O(n)
         c.right = r;
    }
}
