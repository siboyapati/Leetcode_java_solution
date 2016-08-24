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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
            dm->head
            cur=dm
            i=m
            while i-->1:
                cur=cur.next
            i=n-m
            mid_prev=cur
            cur=cur.next
            mid_prev.next=null
            mid_tail=cur
            while i-->=0:
                old_next=mid_prev.next
                node=cur
                cur=cur.next
                node.next=old_next
                mid_prev.next=node
            mid_tail.next=cur
            return dm.next
        */
        
        ListNode dm = new ListNode(-1);
        dm.next = head;
        ListNode cur = dm;
        int i = m;
        while(i-- > 1) cur = cur.next;
        i = n - m;
        ListNode midPrev = cur;
        cur = cur.next;
        midPrev.next = null;
        ListNode midTail = cur;
        while (i-- >= 0) {
            ListNode oldNext = midPrev.next;
            ListNode node = cur;
            cur = cur.next;
            node.next = oldNext;
            midPrev.next = node;
        }
        midTail.next = cur;
        return dm.next;
    }
}
