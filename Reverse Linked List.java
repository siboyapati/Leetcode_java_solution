/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = head;
        while(cursor !=null) {
            ListNode tmp = cursor;
            cursor = cursor.next;
            tmp.next = null;
            ListNode oldNext = dummy.next;
            dummy.next=tmp;
            tmp.next=oldNext;
        }
        return dummy.next;
    }
}
