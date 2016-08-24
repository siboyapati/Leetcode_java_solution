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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree0(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode buildTree0(int[] preorder, int ipre, int jpre, int[] inorder, int iin, int jin) {
        if(jpre <= ipre || jin <= iin) return null;
        TreeNode root = new TreeNode(preorder[ipre]);
        int i=iin;
        for(; i<jin; i++) {
            if(inorder[i] == preorder[ipre]) break;
        }
        root.left = buildTree0(preorder, ipre+1, ipre+1+i-iin, inorder, iin, i);
        root.right = buildTree0(preorder, ipre+1+i-iin, jpre, inorder, i+1, jin);
        return root;
    }
    // T(N)=O(N)+2T(N/2) ==> time O(nlogn)
    // space O(N) + extra O(logn)
}
