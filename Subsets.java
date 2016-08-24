import java.util.*;
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        for(int n=0; n<(1<<S.length); n++) {
            List<Integer> l = new ArrayList<Integer>();
            for(int i=0; i<S.length; i++) {
                if(((n>>>i)&0x1)!=0) l.add(S[i]);
            }
            r.add(l);
        }
        return r;
    }
}
