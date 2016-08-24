import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class DLNode {
        int key, value;
        DLNode prev, next;

        DLNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, DLNode> cache;
    private int capacity, size;
    private DLNode dummyFirst, dummyLast;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, DLNode>();
        size = 0;
        dummyFirst = new DLNode(-1, -1);
        dummyLast = new DLNode(-1, -1);
        dummyFirst.next = dummyLast;
        dummyLast.prev = dummyFirst;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int v = cache.get(key).value;
            this.set(key, v);
            return v;
        } else return -1;
    }

    public void set(int key, int value) {
        if (size == 0) {
            DLNode node = new DLNode(key, value);
            dummyFirst.next = node;
            node.next = dummyLast;
            dummyLast.prev = node;
            node.prev = dummyFirst;
            cache.put(key, node);
            size++;
        } else if (cache.containsKey(key)) {
            DLNode node = cache.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            cache.remove(key);
            size--;
            this.set(key, value);
        } else if (size >= capacity) {
            DLNode node = dummyFirst.next;
            dummyFirst.next = node.next;
            node.next.prev = dummyFirst;
            node.next = null;
            node.prev = null;
            cache.remove(node.key);
            size--;
            this.set(key, value);
        } else {
            DLNode node = new DLNode(key, value);
            dummyLast.prev.next = node;
            node.prev = dummyLast.prev;
            node.next = dummyLast;
            dummyLast.prev = node;
            cache.put(key, node);
            size++;
        }
    }
}


/*
class LRUCache:
    
    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity=capacity
        self.dic={}
        self.dummy_first=DLNode(-1,-1)
        self.dummy_last=DLNode(-1, -1)
        self.dummy_first.next=self.dummy_last
        self.dummy_last.prev=self.dummy_first
        self.size=0

    # @return an integer
    def get(self, key):
        if self.dic.__contains__(key):
            v = self.dic[key].value
            self.set(key, v)
            return v
        else:
            return -1

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if self.size==0:
            n=DLNode(key,value)
            self.dummy_first.next=n
            n.prev=self.dummy_first
            n.next=self.dummy_last
            self.dummy_last.prev=n
            self.dic[key]=n
            self.size=1
        elif self.dic.__contains__(key):
            n=self.dic[key]
            n.prev.next=n.next
            n.next.prev=n.prev
            del self.dic[key]
            self.size-=1
            self.set(key,value)
        elif self.size<self.capacity:
            n=DLNode(key,value)
            self.dummy_last.prev.next=n
            n.prev=self.dummy_last.prev
            n.next=self.dummy_last
            self.dummy_last.prev=n
            self.dic[key]=n
            self.size+=1
        else:
            n=self.dummy_first.next
            n.prev=None
            self.dummy_first.next=n.next
            n.next.prev=self.dummy_first
            n.next=None
            del self.dic[n.key]
            self.size-=1
            self.set(key,value)
        
class DLNode:
    def __init__(self, k, v, prev=None, next=None):
        self.key = k
        self.value = v
        self.prev = prev
        self.next = next
*/
