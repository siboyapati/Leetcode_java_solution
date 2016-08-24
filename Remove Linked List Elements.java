/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur1 = dummy;
        ListNode cur2 = head;
        while(cur2 != null) {
            ListNode tmp = cur2;
            cur2 = cur2.next;
            tmp.next = null;
            if (tmp.val != val) {
                cur1.next = tmp;
                cur1 = cur1.next;
            }
        }
        return dummy.next;
    }
}
