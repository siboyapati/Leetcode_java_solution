import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if(numRows <= 0) return r;
        List<Integer> r1 = new ArrayList<Integer>();
        r1.add(1);
        r.add(r1);
        if(numRows==1) return r;
        List<Integer> r2 = new ArrayList<Integer>();
        r2.add(1);
        r2.add(1);
        r.add(r2);
        if(numRows==2) return r;
        for(int i=3; i<=numRows; i++) {
            List<Integer> ri = new ArrayList<Integer>();
            ri.add(1);
            for(int j=0; j<i-2; j++) ri.add(r.get(i-2).get(j)+r.get(i-2).get(j+1));
            ri.add(1);
            r.add(ri);
        }
        return r;
    }
}
