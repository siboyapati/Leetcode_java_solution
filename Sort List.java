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
    public ListNode sortList(ListNode head) {
        /*
            standard top down merge sort
            T(N)=O(N)+2T(N/2) ==> time O(nlog(n))
            recursive ==> space O(log(n))
            
            bottom up merge sort
            time O(nlog(n))
            space O(1)
            
            #get len of list
            len=0
            c=head
            while c!=null:
                c=c.next
                len++
                
            p=1
            dm
            while p < len:
                c=dm
                c1,c2,c3=head,head,null
                
                while c2!=null:
                    for i=0;i<p-1;i++:
                        if c2!=null:
                            c2=c2.next
                        else:
                            break
                    if c2!=null:
                        tail=c2
                        c2=c2.next
                        tail.next=null
                        
                        c3=c2
                        for i=0;i<p-1;i++:
                            if c3!=null:
                                c3=c3.next
                            else:
                                break
                        if c3!=null:
                            tail=c3
                            c3=c3.next
                            tail.next=null
                    
                    while c1!=null and c2!=null:
                        if c1.val <= c2.val:
                            c.next=c1
                            c=c.next
                            c1=c1.next
                        else:
                            c.next=c2
                            c=c.next
                            c2=c2.next
                    while c1!=null:
                        c.next=c1
                        c=c.next
                        c1=c1.next
                    while c2!=null:
                        c.next=c1
                        c=c.next
                        c2=c2.next
                        
                    c1,c2=c3,c3
                    c3=null
                    
                p *= 2
                head=dm.next
                dm.next=null
                
            return dm.next
        */
        
        int len = 0;
        ListNode c;
        for (c=head; c!=null; c=c.next) len++;
        
        ListNode dm = new ListNode(-1);
        for (int p=1; p<=len; p*=2) {
            dm.next = null;
            c = dm;
            
            ListNode c1=head, c2=head, c3=null;
            while(c1 != null) {
                c3 = null;
                for(int i=0; i<p-1; i++){
                    if(c2 != null) c2 = c2.next;
                    else break;
                }
                if (c2 != null) {
                    ListNode tmp = c2;
                    c2=c2.next;
                    tmp.next=null;
                    
                    c3 = c2;
                    for(int i=0; i<p-1; i++) {
                        if(c3 != null) c3 = c3.next;
                        else break;
                    }
                    if (c3 != null) {
                        tmp = c3;
                        c3 = c3.next;
                        tmp.next = null;
                    }
                }
                
                while(c1 != null && c2 != null) {
                    if(c1.val <= c2.val){
                        c.next = c1;
                        c = c.next;
                        c1 = c1.next;
                    } else {
                        c.next = c2;
                        c = c.next;
                        c2 = c2.next;
                    }
                }
                while(c1 != null) {
                    c.next = c1;
                    c = c.next;
                    c1 = c1.next;
                }
                while(c2 != null) {
                    c.next = c2;
                    c = c.next;
                    c2 = c2.next;
                }
                
                c1 = c3;
                c2 = c3;
            }
            head = dm.next;
        }
        return dm.next;
    }
}
