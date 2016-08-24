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
    public ListNode insertionSortList(ListNode head) {
        ListNode resultDummyHead = new ListNode(-1);
        ListNode cursor = head;
        while(cursor != null) {
            ListNode node = cursor;
            cursor = cursor.next;
            node.next = null;
            if(resultDummyHead.next == null) {
                resultDummyHead.next = node;
            } else {
                ListNode cur = resultDummyHead;
                while(cur.next != null && cur.next.val < node.val) {
                    cur = cur.next;
                }
                if(cur.next == null) {
                    cur.next = node;
                } else {
                    node.next = cur.next;
                    cur.next = node;
                }
            }
        }
        return resultDummyHead.next;
    }
}
