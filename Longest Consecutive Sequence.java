import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        /*
            def longestConsecutive(self, num):
                d={}
                visited=set()
                m=1
                for n in num:
                    d[n]=1
                for n in num:
                    if not visited.__contains__(n):
                        while d.__contains__(n-1):
                            n-=1
                        visited.add(n)
                        while d.__contains__(n+1):
                            d[n+1]=d[n]+1
                            m=max(m,d[n+1])
                            n+=1
                            visited.add(n)
                return m
        */
        Map<Integer,Integer> d = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int m = 1;
        for(int i =0; i<num.length;i++) {
            d.put(num[i], 1);
        }
        for(int i =0; i<num.length;i++) {
            int n = num[i];
            if(!visited.contains(n)) {
                while(d.containsKey(n-1)) n--;
                visited.add(n);
                while(d.containsKey(n+1)) {
                    d.put(n+1,d.get(n)+1);
                    m = Math.max(m,d.get(n+1));
                    n++;
                    visited.add(n);
                }
            }
        }
        return m;
    }
}
