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
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
            stack s
            list l
            current=root
            while s not empty or current not null:
                if current not null:
                    s.push current
                    current=current.left
                else:
                    current=s.pop
                    l.add current.val
                    current=current.right
            return l
        */
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;
        while(!stack.isEmpty() || current!=null) {
            if(current!=null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}
