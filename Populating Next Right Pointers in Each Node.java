/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        /*
            if recursion is allowed:
            
            if root==null:
                return
            l=root.left
            r=root.right
            while l!=null:
                l.next = r
                l=l.right
                r=r.left
            connect(root.left)
            connect(root.right)
            
            time T(N)=2T(N/2)+O(log(N)) ==> T(n)=O(nloglogn)
            space O(logn)
        */
        if(root==null) return;
        TreeLinkNode l=root.left, r=root.right;
        connect(l);
        connect(r);
        while(l!=null) {
            l.next=r;
            l=l.right;
            r=r.left;
        }
    }
}
