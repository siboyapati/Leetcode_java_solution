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
    public void recoverTree(TreeNode root) {
        /*
            prev=null
            list reversions
            
            stack s
            cur = root
            while cur!=null or s not empty:
                if cur!=null:
                    s.push cur
                    cur = cur.left
                else:
                    cur = s.pop
                    
                    #visit cur
                    if prev!=null && prev.val > cur.val:
                        reversions.add(prev)
                        reversions.add(cur)
                    prev = cur
                    
                    cur = cur.right
            if reversions.size == 2:
                swap reversions[0], reversions[1]
            else if reversions.size == 4:
                swap reversions[0], reversions[3]
            else:
                throw new IllegalArgumentException
        */
        TreeNode prev = null;
        ArrayList<TreeNode> reversions = new ArrayList<TreeNode>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if(prev!=null && prev.val>current.val) {
                    reversions.add(prev);
                    reversions.add(current);
                }
                prev = current;
                current = current.right;
            }
        }
        int tmp = reversions.get(0).val;
        reversions.get(0).val = reversions.get(reversions.size()-1).val;
        reversions.get(reversions.size()-1).val = tmp;
    }
}
