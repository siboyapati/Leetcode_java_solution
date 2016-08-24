public class Solution {
    public int maxSubArray(int[] A) {
        /*
            m=A[0]
            c=A[0]>0?A[0]:0
            for(int i=1; i<A.length; i++) {
                c+=A[i]
                m=Math.max(m,c)
                c=Math.max(c,0)
            }
            return m
        */
        int max = A[0];
        int sum = A[0] > 0 ? A[0] : 0;
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
