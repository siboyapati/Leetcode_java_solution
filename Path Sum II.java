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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        /*
            stack s
            node c=root
            last = null
            while s not empty || c not null:
                if c not null:
                    s.push c
                    if c is leaf and c.val==sum:
                        add all elements in stack to result
                    if c.left!=null:
                        c.left.val+=c.val
                    c=c.left
                else:
                    c=s.pop
                    if c.right==null||last==c.right:
                        retore c.left.val and c.right.val
                        last=c
                        c=null
                    else:
                        s.push c
                        if c is leaf and c.val==sum:
                            add all elements in stack to result
                        if c.right!=null:
                            c.right.val+=c.val
                        c=c.right
        */
        LinkedList<TreeNode> s = new LinkedList<TreeNode>();
        TreeNode c = root;
        TreeNode last = null;
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        while (!s.isEmpty() || c!=null) {
            if (c!=null) {
                s.push(c);
                if(c.left==null && c.right==null && c.val==sum) {
                    List<Integer> r1 = new ArrayList<Integer>();
                    for(int i=s.size()-1; i>=0; i--) r1.add(s.get(i).val);
                    for(int i=r1.size()-1; i>0; i--) r1.set(i, r1.get(i) - r1.get(i-1));
                    r.add(r1);
                }
                if (c.left!=null) c.left.val += c.val;
                c = c.left;
            } else {
                c = s.pop();
                if(c.right==null || last==c.right) {
                    if(c.left!=null) c.left.val -= c.val;
                    if(c.right!=null) c.right.val -= c.val;
                    last = c;
                    c = null;
                } else {
                    s.push(c);
                    if(c.left==null && c.right==null && c.val==sum) {
                        List<Integer> r1 = new ArrayList<Integer>();
                        for(int i=s.size()-1; i>=0; i--) r1.add(s.get(i).val);
                        for(int i=r1.size()-1; i>0; i--) r1.set(i, r1.get(i) - r1.get(i-1));
                        r.add(r1);
                    }
                    if(c.right!=null) c.right.val += c.val;
                    c = c.right;
                }
            }
        }
        return r;
    }
}
