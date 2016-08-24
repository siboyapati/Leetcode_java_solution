import java.util.*;
public class Solution {
    public List<Integer> grayCode(int n) {
        /*
        0 1
        00 01 11 10
        000 001 011 010 110 111 101 100
        0000 0001 0011 0010 0110 0111 0101 0100 1100 1101 1111 1110 1010 1011 1001 1000
        */
        List<Integer> r = new ArrayList<Integer>();
        if(n < 0) return r;
        if(n == 0) {
            r.add(0);
            return r;
        }
        r.add(0); r.add(1);
        for(int i=1; i<n; i++) {
            int len = r.size();
            for(int j=len-1; j>=0; j--) {
                r.add((1<<i) + r.get(j));
            }
        }
        return r;
    }
}
