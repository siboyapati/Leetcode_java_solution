public class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return climb(n, map);
    }
    private int climb(int n, HashMap<Integer,Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        if(n<=1) return 1;
        if(n==2) return 2;
        int r2 = climb(n-2, map);
        map.put(n-2,r2);
        int r1 = climb(n-1, map);
        map.put(n-1,r1);
        int r = r1+r2;
        map.put(n, r1+r2);
        return r;
    }
}
