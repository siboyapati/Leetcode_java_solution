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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode prev = null;
        int level = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null) {
            if (level == result.size()) {
                result.add(cur.val);
            }
            if (cur.right != null && prev != cur.right && (cur.left == null || cur.left !=prev)) {
                stack.push(cur);
                cur = cur.right;
                level++;
            } else if (cur.left != null && prev != cur.left) {
                stack.push(cur);
                cur = cur.left;
                level++;
            } else {
                prev = cur;
                if(stack.isEmpty()) return result;
                cur = stack.pop();
                level--;
            }
        }
        return result;
    }
}
