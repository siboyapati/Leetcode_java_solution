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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0;
        int lenB = 0;
        while(currA != null) {
            currA = currA.next;
            lenA++;
        }
        while(currB != null) {
            currB = currB.next;
            lenB++;
        }
        currA = headA;
        currB = headB;
        if(lenA>lenB) {
            int delta = lenA - lenB;
            for(int i=0; i<delta; i++) currA = currA.next;
        }
        if(lenB>lenA) {
            int delta = lenB - lenA;
            for(int i=0; i<delta; i++) currB = currB.next;
        }
        while(currA != null) {
            if(currA==currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}
