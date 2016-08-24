/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        /*
            dm
            cur=dm
            c=head
            while c!=null and c.next!=null:
                n1=c
                c=c.next
                n1.next=null
                n2=c
                c=c.next
                n2.next=null
                cur.next=n2
                cur=cur.next
                cur.next=n1
                cur=cur.next
            if c!=null:
                assert c.next==null
                cur.next=c
            return dm.next
            
            test: 0 1 2
        */
        
        ListNode dm = new ListNode(-1);
        ListNode cur = dm;
        ListNode c = head;
        while(c!=null && c.next!=null) {
            ListNode n1 = c;
            c = c.next;
            n1.next = null;
            ListNode n2 = c;
            c = c.next;
            n2.next = null;
            cur.next = n2;
            cur = cur.next;
            cur.next = n1;
            cur = cur.next;
        }
        if (c!=null) cur.next = c;
        return dm.next;
    }
}
