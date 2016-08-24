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
         * dm->head
         * c1 = dm, c2 = head, c3 = head
         * while c3.next!=null:
         *  c3 = c3.next
         *  if c3.val==c2.val:
         *      c2IsDup=true
         *  else:
         *      if c2IsDup:
         *          c2IsDup=false
         *      else:
         *          c1.next=c2
         *          c1=c1.next
         *      c2=c3
         * if !c2IsDup:
         *  c1.next = c2
         *  c1=c1.next
         * c1.next=null
         * return dm.next;
         */
         
         if(head==null || head.next==null) return head;
         ListNode dm = new ListNode(-1);
         dm.next = head;
         ListNode c1 = dm, c2 = head, c3 = head;
         
         boolean c2IsDup = false;
         while(c3.next != null) {
             c3 = c3.next;
             if(c3.val == c2.val) {
                 c2IsDup = true;
             } else {
                 if(c2IsDup) c2IsDup = false;
                 else {
                     c1.next = c2;
                     c1 = c1.next;
                 }
                 c2 = c3;
             }
         }
         if(!c2IsDup) {
             c1.next = c2;
             c1 = c1.next;
         }
         c1.next = null;
         return dm.next;
    }
}
