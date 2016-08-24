import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        /*
            if len(num)<=1:
                return [num]
            result = []
            for n in set(num):
                num1 = [i for i in num]
                num1.remove(n)
                for r in self.permute(num1):
                    r.append(n)
                    result.append(r)
            return result
        */
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length==0) return result;
        List<Integer> l = new ArrayList<Integer>();
        if(num.length==1) {
            l.add(num[0]);
            result.add(l);
            return result;
        }
        Arrays.sort(num);
        for(int i=0; i<num.length; i++) {
            if(i==0 || num[i]!=num[i-1]) {
                int[] num1 = new int[num.length-1];
                for(int j=0; j<num.length; j++) {
                    if(j<i) num1[j]=num[j];
                    if(j>i) num1[j-1]=num[j];
                }
                for(List<Integer> r : permute(num1)) {
                    r.add(num[i]);
                    result.add(r);
                }
            }
        }
        return result;
    }
}
