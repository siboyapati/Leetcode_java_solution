/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        /*
            cur=head
            while cur!=null:
                node = new node(cur.label)
                old_next = cur.next
                cur.next=node
                node.next=old_next
                cur=old_next
            cur=head
            while cur!=null:
                if cur.random!=null:
                    cur.next.random=cur.random.next
                cur=cur.next.next
            cur=head
            if head==null:
                return null
            new_head=cur.next
            while cur!=null:
                node=cur.next
                cur.next=cur.next.next
                if node!=null and node.next!=null:
                    node.next=node.next.next
                cur=cur.next
            return new_head
        */
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            RandomListNode oldNext = cur.next;
            cur.next = node;
            node.next = oldNext;
            cur = oldNext;
        }
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        if (head==null) return null;
        RandomListNode newHead = cur.next;
        while(cur != null) {
            RandomListNode node = cur.next;
            cur.next = cur.next.next;
            if(node != null && node.next != null) node.next = node.next.next;
            cur = cur.next;
        }
        return newHead;
    }
}
