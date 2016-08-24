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
    public List<Integer> postorderTraversal(TreeNode root) {
        /*
            stack
            lastVisited=null
            current=root
            while !stack.isEmpty() || current!=null:
                if current!=null:
                    stack.push current
                    current=current.left
                else:
                    current=stack.pop
                    if current.right==null || lastVisited==current.right:
                        visit current
                        lastVisited=current
                        current=null
                    else:
                        stack.push current
                        current=current.right
        */
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode lastVisited = null, current = root;
        List<Integer> r = new ArrayList<Integer>();
        while(!stack.isEmpty() || current!=null) {
            if(current!=null) {
                stack.push(current);
                current=current.left;
            }else {
                current = stack.pop();
                if(current.right==null || lastVisited==current.right) {
                    r.add(current.val);
                    lastVisited=current;
                    current=null;
                }else{
                    stack.push(current);
                    current=current.right;
                }
            }
        }
        return r;
    }
}
