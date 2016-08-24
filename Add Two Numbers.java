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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            cur.next = new ListNode((sum + carry) % 10);
            cur = cur.next;
            carry = (sum + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            cur.next = new ListNode((l1.val + carry) % 10);
            cur = cur.next;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }
        while(l2 != null) {
            cur.next = new ListNode((l2.val + carry) % 10);
            cur = cur.next;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        if(carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
