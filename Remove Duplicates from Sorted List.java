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
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * if head==null || len == 1: return head
         * cur1=head, cur2=head.next
         * while cur2!=null:
         *  if cur2.val != cur1.val:
         *      cur1.next=cur2
         *      cur1=cur1.next
         *  cur2=cur2.next
         * cur1.next=null
         */
         
         if(head==null||head.next==null) return head;
         ListNode cur1=head, cur2=head.next;
         
         while(cur2 != null) {
             if(cur2.val != cur1.val) {
                 cur1.next = cur2;
                 cur1 = cur1.next;
             }
             cur2 = cur2.next;
         }
         cur1.next = null;
         return head;
    }
}
