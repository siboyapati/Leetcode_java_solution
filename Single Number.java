public class Solution {
    public int singleNumber(int[] A) {
        int r = 0;
        for(int i=0; i<A.length; i++) {
            r ^= A[i];
        }
        return r;
    }
}
