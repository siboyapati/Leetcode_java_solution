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
    public ListNode rotateRight(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while(node!=null) {
            node = node.next;
            len++;
        }
        
        if(len == 0) return head;
        n %= len;
        
        if(n==0) return head;
        
        node = head;
        for(int i = 0; i < len - n - 1; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        node = newHead;
        while(node.next != null) {
            node = node.next;
        }
        node.next = head;
        
        return newHead;
    }
}
