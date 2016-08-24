class MyStack {
    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    ArrayDeque<Integer> r = new ArrayDeque<Integer>();
    ArrayDeque<Integer> t;
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for(int i=0; i<size-1;i++) {
            r.add(q.removeFirst());
        }
        q.removeFirst();
        t = q;
        q = r;
        r = t;
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        for(int i=0; i<size-1;i++) {
            r.add(q.removeFirst());
        }
        int ret = q.removeFirst();
        r.add(ret);
        t = q;
        q = r;
        r = t;
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
