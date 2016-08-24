/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
            s,f=head,head
            while f!=null and f.next!=null:
                s=s.next
                f=f.next.next
                if s==f:
                    break
            if f==null or f.next==null:
                return null
            len=1
            f=f.next
            while f!=s:
                len++
                f=f.next
            s,f=head,head
            while len-->0:
                f=f.next
            while s!=f:
                s=s.next
                f=f.next
            return s
        */
        ListNode s=head, f=head;
        while(f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
            if (s==f) break;
        }
        if(f==null || f.next==null) return null;
        int len=1;
        f=f.next;
        while (f!=s) {
            len++;
            f=f.next;
        }
        s=head;
        f=head;
        while(len-- > 0) f=f.next;
        while(s!=f){
            f=f.next;
            s=s.next;
        }
        return s;
    }
}
