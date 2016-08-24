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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree0(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    private TreeNode buildTree0(int[] inorder, int iin, int jin, int[] postorder, int ipost, int jpost) {
        if(jin <= iin || jpost <= ipost) return null;
        TreeNode root = new TreeNode(postorder[jpost-1]);
        int i=iin;
        for(; i<jin; i++) {
            if(inorder[i]==postorder[jpost-1]) break;
        }
        root.left = buildTree0(inorder, iin, i, postorder, ipost, ipost+i-iin);
        root.right= buildTree0(inorder, i+1, jin, postorder, ipost+i-iin, jpost-1);
        return root;
    }
}
