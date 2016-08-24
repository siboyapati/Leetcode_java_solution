import java.util.*;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        /*
            def subsetsWithDup(self, S):
                ret=[[]]
                d={}
                for n in S:
                    if d.__contains__(n):
                        d[n]+=1
                    else:
                        d[n]=1
                for n in d:
                    ret1=copy.deepcopy(ret)
                    for i in range(1,d[n]+1):
                        for r in ret1:
                            rr = r+[n]*i
                            rr.sort()
                            ret.append(rr)
                return ret
        */
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        Map<Integer,Integer> d = new HashMap<Integer,Integer>();
        for(int n: num) {
            if(d.containsKey(n)) d.put(n, d.get(n)+1);
            else d.put(n,1);
        }
        List<Integer> ks = new ArrayList<Integer>(d.keySet());
        Collections.sort(ks);
        for(int n:ks) {
            int len = ret.size();
            for(int i=1; i<d.get(n)+1; i++) {
                for(int j=0;j<len;j++) {
                    List<Integer> r = ret.get(j);
                    List<Integer> rr = new ArrayList<Integer>(r);
                    for(int k=0;k<i;k++) rr.add(n);
                    ret.add(rr);
                }
            }
        }
        return ret;
    }
}
