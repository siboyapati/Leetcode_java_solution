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
    public List<Integer> preorderTraversal(TreeNode root) {
        //stack
        List<Integer> r = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if(root==null) return r;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            r.add(n.val);
            if(n.right!=null) stack.push(n.right);
            if(n.left!=null) stack.push(n.left);
        }
        return r;
    }
}
