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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=0, rh=0;
        TreeNode ln=root.left;
        TreeNode rn=root.right;
        while(ln!=null) {
            ln=ln.left;
            lh++;
        }
        while(rn!=null) {
            rn=rn.right;
            rh++;
        }
        if(lh==rh) return (1<<(lh+1))-1;
        return countNodes(root.left)+countNodes(root.right)+1;
        //T(n)=T(n/2)+O(log(n)) => O(log(n)*log(n)) == O(h^2)
    }
}
