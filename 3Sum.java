import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        /*
            quick sort num
            for i in [0..num.length-1]:
                for j in [i+1..num.length-1]:
                    dict.(i+j).add((i,j)) if doesn't exist
            for n in num:
                for (a,b) in dict.(-n):
                    result.add((n,a,b).sort!) if doesn't exist
            
            time O(n^2) space O(n^2)
        */
        Arrays.sort(num);
        HashMap<Integer,HashSet<Integer>> dict = new HashMap<Integer,HashSet<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                int key = num[i] + num[j];
                HashSet<Integer> vs = dict.containsKey(key) ? dict.get(key) : new HashSet<Integer>();
                assert i<(1<<16) && j<(1<<16);
                vs.add((i<<16)+j);
                dict.put(key, vs);
            }
        }
        for(int k = 0; k < num.length; k++) {
            if(dict.containsKey(-num[k])) {
                for(Integer indices : dict.get(-num[k])) {
                    int i = indices>>16;
                    int j = indices&0x0000ffff;
                    if(k > j) {
                        List<Integer> tl = new ArrayList<Integer>();
                        tl.add(num[i]);
                        tl.add(num[j]);
                        tl.add(num[k]);
                        set.add(tl);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
