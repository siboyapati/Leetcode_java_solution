/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r = new LinkedList<List<Integer>>();
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        if(root==null) return r;
        q.offer(root);
        while(!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i=0; i<len; i++) {
                TreeNode n = q.poll();
                level.add(n.val);
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            r.add(0, level);
        }
        return r;
    }
}
