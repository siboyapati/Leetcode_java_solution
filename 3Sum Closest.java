import java.util.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // time O(n^2log(n)) space O(log(n))
        Arrays.sort(num);
        int diff = 0x7fffffff;
        for(int i = 0; i < num.length; i++) {
            for(int j = i+1; j < num.length; j++) {
                int t = target - num[i] - num[j];
                int k = Arrays.binarySearch(num, j+1, num.length, t);
                if(k>=0) return target;
                else {
                    if((~k)<num.length && Math.abs(target-num[~k]-num[i]-num[j]) < Math.abs(diff)) 
                        diff = target-num[~k]-num[i]-num[j];
                    if((~k)>j+1 && (~k)<=num.length && Math.abs(target-num[(~k)-1]-num[i]-num[j]) < Math.abs(diff)) 
                        diff = target-num[(~k)-1]-num[i]-num[j];
                }
            }
        }
        return target - diff;
    }
}
