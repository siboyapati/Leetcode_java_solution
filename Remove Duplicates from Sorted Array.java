public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null) return 0;
        if(A.length <= 1) return A.length;
        int i = 0, j = 1;
        while(j < A.length) {
            if(A[j] != A[i]) {
                i++;
                int t = A[j];
                A[j] = A[i];
                A[i] = t;
            }
            j++;
        }
        return i + 1;
        
        /**
         * test
         * 
         * 1. [1 1]
         * 2. [1 2]
         * 3. [1 1 2]
         * 4. [1 2 1] invalid input
         * 5. [1 2 2]
         * 6. []
         */
    }
}
