public class Solution {
    public int numTrees(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1); 
        map.put(1, 1);
        return numTrees0(n, map);
    }
    private int numTrees0(int n, HashMap<Integer, Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        int r = 0;
        for(int i=0; i<n; i++) {
            
            r += numTrees0(i, map) * numTrees0(n - 1 - i, map);
        }
        map.put(n, r);
        return r;
    }
}
