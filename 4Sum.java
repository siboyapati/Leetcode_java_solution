import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        /*
            hashmap doesn't make sense here cause O(n^3)/O(n^3) is not much better than O(n^3log(n))/O(log(n))
        */
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                for(int k=j+1; k<num.length; k++) {
                    int l = Arrays.binarySearch(num, k+1, num.length, target-num[i]-num[j]-num[k]);
                    if(l > 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[l]);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
