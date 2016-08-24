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
            def connect(self, root):
                cur,head,prev=root,None,None
                while cur:
                    while cur:
                        if cur.left:
                            if prev:
                                prev.next=cur.left
                            else:
                                head=cur.left
                            prev=cur.left
                        if cur.right:
                            if prev:
                                prev.next=cur.right
                            else:
                                head=cur.right
                            prev=cur.right
                        cur=cur.next
                    cur=head
                    head,prev=None,None
            '''
            def connect(self, root):
                if not root:
                    return
                q=[root]
                while q:
                    size=len(q)
                    prev=None
                    for n in q[:size]:
                        if n.left:
                            q.append(n.left)
                        if n.right:
                            q.append(n.right)
                        if prev:
                            prev.next=n
                        prev=n
                    q=q[size:]'''
        */
        TreeLinkNode cur=root, head=null, prev=null;
        while(cur!=null) {
            while(cur!=null) {
                if(cur.left!=null) {
                    if(prev!=null) prev.next = cur.left;
                    else head = cur.left;
                    prev=cur.left;
                }
                if(cur.right!=null) {
                    if(prev!=null) prev.next = cur.right;
                    else head = cur.right;
                    prev=cur.right;
                }
                cur=cur.next;
            }
            cur=head;
            head=null;
            prev=null;
        }
    }
}
