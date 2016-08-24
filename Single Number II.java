public class Solution {
    public int singleNumber(int[] A) {
        int[] bitCount = new int[32];
        for(int i = 0; i < A.length; i++) {
            int n = A[i];
            int b = 0;
            while(n != 0) {
                if((n & 1) != 0) {
                    bitCount[b]++;
                    bitCount[b] %= 3;
                }
                n >>>= 1;
                b++;
            }
        }
        int r=0;
        for(int i=0; i<32; i++) {
            if(bitCount[i] != 0) {
                r |= (1 << i);
            }
        }
        return r;
    }
}
