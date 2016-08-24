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
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
            if k<2: 
                return head
            dm
            c=dm
            c1=head
            while c1!=null:
                l=0
                segHead=c1
                while c1!=null and l<k-1:
                    c1=c1.next
                    l++
                if l==k-1 and c1!=null:
                    segTail=c1
                    c1=c1.next
                    segTail.next=null
                    
                    c2=segHead
                    while c2!=null:
                        oldNext=c.next
                        node=c2
                        c2=c2.next
                        node.next=null
                        c.next=node
                        node.next=oldNext
                    c=segHead
                else:
                    c.next=segHead
            return dm.next
        */
        if(k < 2) return head;
        ListNode dm = new ListNode(-1);
        ListNode c= dm;
        ListNode c1 = head;
        while (c1 != null) {
            int l = 0;
            ListNode segHead = c1;
            while (c1!=null && l<k-1) {
                c1 = c1.next;
                l++;
            }
            if (l == k-1 && c1 != null) {
                ListNode segTail = c1;
                c1 = c1.next;
                segTail.next = null;
                ListNode c2 = segHead;
                while (c2 != null) {
                    ListNode oldNext = c.next;
                    ListNode node = c2;
                    c2 = c2.next;
                    node.next = null;
                    c.next = node;
                    node.next = oldNext;
                }
                c = segHead;
            }
            else c.next = segHead;
        }
        return dm.next;
    }
}
