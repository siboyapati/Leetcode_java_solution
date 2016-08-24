/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        /*
            '''test
                0
                1
                2 s=1
                3 s=2
                4 s=2
                5 s=3
            '''
            if head==null || head.next==null:
                return
            s,f=head,head.next
            while f!=null and f.next!=null:
                s=s.next
                f=f.next.next
            dm1.next=head
            tmp=s
            s=s.next
            tmp.next=null
            dm2
            while s!=null:
                node=s
                s=s.next
                node.next=null
                oldNext=dm2.next
                dm2.next=node
                node.next=oldNext
            c1=dm1.next
            c2=dm2.next
            dm
            c=dm
            while c1!=null and c2!=null:
                n1=c1
                c1=c1.next
                n1.next=null
                c.next=n1
                c=c.next
                n2=c2
                c2=c2.next
                n2.next=null
                c.next=n2
                c=c.next
            if c1!=null:
                c.next=c1
            if c2!=null:
                c.next=c2
        */
        if(head==null || head.next==null) return;
        ListNode s=head, f=head.next;
        while(f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
        }
        ListNode dm1 = new ListNode(-1);
        dm1.next = head;
        ListNode tmp = s;
        s = s.next;
        tmp.next = null;
        ListNode dm2 = new ListNode(-1);
        while (s!=null) {
            ListNode node = s;
            s = s.next;
            node.next = null;
            ListNode oldNext = dm2.next;
            dm2.next = node;
            node.next = oldNext;
        }
        ListNode c1 = dm1.next;
        ListNode c2 = dm2.next;
        ListNode dm = new ListNode(-1);
        ListNode c = dm;
        while (c1!=null && c2!=null) {
            ListNode n1 = c1;
            c1 = c1.next;
            n1.next = null;
            c.next = n1;
            c = c.next;
            ListNode n2 = c2;
            c2 = c2.next;
            n2.next = null;
            c.next = n2;
            c = c.next;
        }
        if(c1 != null) c.next = c1;
        if(c2 != null) c.next = c2;
    }
}
