import java.util.*;

class MinStack {
    public void push(int x) {
        if(arr.size()==0) arr.add(new Elem(x, x));
        else {
            int min = Math.min(arr.get(arr.size()-1).min,x);
            arr.add(new Elem(x, min));
        }
    }

    public void pop() {
        if(arr.size()==0) throw new java.util.EmptyStackException();
        arr.remove(arr.size()-1);
    }

    public int top() {
        if(arr.size()==0) throw new java.util.EmptyStackException();
        return arr.get(arr.size()-1).val;
    }

    public int getMin() {
        if(arr.size()==0) throw new java.util.EmptyStackException();
        return arr.get(arr.size()-1).min;
    }
    private ArrayList<Elem> arr = new ArrayList<Elem>();
    private static class Elem {
        int val;
        int min;
        Elem(int v, int m) {
            val = v;
            min = m;
        }
    }
}
