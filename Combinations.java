import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        assert n>=k && k>0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i=1; i<=n; i++) set.add(i);
        return combine0(set, k);
    }
    private List<List<Integer>> combine0(Set<Integer> set, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==1) {
            for(int n : set) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(n);
                result.add(l);
            }
            return result;
        }
        for(int n: set) {
            HashSet<Integer> set1 = new HashSet<Integer>(set);
            set1.remove(n);
            for(List<Integer> r : combine0(set1, k-1)) {
                r.add(n);
                result.add(r);
            }
        }
        return result;
    }
}
