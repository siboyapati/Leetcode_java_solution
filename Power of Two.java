public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int bitCount = 0;
        while(n>0) {
            if(n%2!=0) {
                bitCount++;
                if(bitCount>1) return false;
            }
            n>>>=1;
        }
        return true;
    }
}
