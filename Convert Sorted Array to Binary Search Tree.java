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
    public TreeNode sortedArrayToBST(int[] num) {
        return f(num, 0, num.length);
    }
    private TreeNode f(int[] num, int i, int j){
        if(j<=i) return null;
        int mid=(i+j)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left=f(num,i,mid);
        root.right=f(num,mid+1,j);
        return root;
    }
}
