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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode node;
        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) {
                node = l1;
                l1 = l1.next;
                
            } else {
                node = l2;
                l2 = l2.next;
            }
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
        /**
         * test
         * 
         * 1. l1=null && l2=null
         * 2. l1=null
         * 3. l2=null
         * 4. l1.len = 1 && l2.len = 1
         * 5. l1.len = 1 && l2.len = 3
         */
    }
}
