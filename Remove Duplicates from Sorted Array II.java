public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null) return -1;
        
        if(A.length==0) return 0;
        int r = 1;
        int c = 1;
        boolean twice=false;
        for(int i=1; i<A.length; i++) {
            if(A[i]==A[i-1]) {
                if(!twice) {
                    r++;
                    twice=true;
                    A[c++]=A[i];
                }
            } else {
                r++;
                twice=false;
                A[c++]=A[i];
            }
        }
        return r;
    }
}
