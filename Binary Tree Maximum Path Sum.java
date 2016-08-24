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
    public int maxPathSum(TreeNode root) {
        Map<TreeNode,Integer> d = new HashMap<TreeNode,Integer>();
        f(root,d);
        return g(root,d);
    }
    private int g(TreeNode root, Map<TreeNode,Integer> d) {
        if(root==null) return 0x80000000;
        int l = g(root.left, d);
        int r = g(root.right, d);
        int res = Math.max(l, r);
        res = Math.max(res, root.val);
        if(root.left != null) res = Math.max(res, d.get(root.left) +root.val);
        if(root.right!= null) res = Math.max(res, d.get(root.right)+root.val);
        if(root.left!=null && root.right!=null) res = Math.max(res,d.get(root.left) + d.get(root.right)+root.val);
        return res;
    }
    private int f(TreeNode root, Map<TreeNode,Integer> d) {
        if(root==null) return 0x80000000;
        if(d.containsKey(root)) return d.get(root);
        d.put(root, Math.max(0, Math.max(f(root.left, d), f(root.right, d))) + root.val);
        return d.get(root);
    }
}
/*
class Solution:
    # @param root, a tree node
    # @return an integer
    def maxPathSum(self, root):
        d={}
        self.f(root, d)
        return self.g(root, d)
    
    def g(self, root, d):
        if not root:
            return 0
        l = self.g(root.left, d)
        r = self.g(root.right,d)
        res = max(l, r, root.val)
        if root.left:
            res = max(res, d[root.left]+root.val)
        if root.right:
            res = max(res, d[root.right]+root.val)
        if root.left and root.right:
            res = max(res, d[root.left]+d[root.right]+root.val)
        return res
    
    def f(self, root, d):
        if not root:
            return -0xdeadbeaf
        if root in d:
            return d[root]
        d[root] = max(0, self.f(root.left,d), self.f(root.right,d)) + root.val
        return d[root]
*/
