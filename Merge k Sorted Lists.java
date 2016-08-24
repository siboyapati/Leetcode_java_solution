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
 
import java.util.*;

public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        /**
         * O(klog(k)*n)
         */
         if(lists == null || lists.isEmpty()) return null;
         ArrayDeque<ListNode> q = new ArrayDeque<ListNode>();
         for(ListNode n : lists) {
             if (n != null) q.offer(n);
         }
         while(q.size() > 1) {
             ListNode a = q.poll();
             ListNode b = q.poll();
             q.offer(merge2Lists(a, b));
         }
         
         return q.poll();
    }
    
    private ListNode merge2Lists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        while(a!=null && b!=null) {
            ListNode n = null;
            if(a.val <= b.val) {
                n = a;
                a = a.next;
            } else {
                n = b;
                b = b.next;
            }
            n.next = null;
            cursor.next = n;
            cursor = cursor.next;
        }
        if(a != null) cursor.next = a;
        if(b != null) cursor.next = b;
        
        return dummy.next;
    }
}
