import java.util.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<Integer>();
        if(rowIndex<0) return r;
        r.add(1);
        if(rowIndex==0) return r;
        r.add(1);
        if(rowIndex==1) return r;
        List<Integer> r1 = new ArrayList<Integer>();
        for(int i=2; i<=rowIndex; i++) {
            r1.add(1);
            for(int j=0; j<i-1; j++) {
                r1.add(r.get(j)+r.get(j+1));
            }
            r1.add(1);
            List<Integer> r2 = r;
            r = r1;
            r1 = r2;
            r1.clear();
        }
        return r;
    }
}
