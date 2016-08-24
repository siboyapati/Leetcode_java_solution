/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayDeque;

public class BSTIterator {

    private ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int retval = node.val;
        if(node.right != null) {
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return retval;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
