public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int r = 0;
        // while (n != 0) {
        //     r += n & 1;
        //     n >>>= 1;
        // }
        // return r;
        
        n = (((n & 0x55555555) << 1) & (n & 0xAAAAAAAA)) | ((n & 0x55555555) ^ ((n & 0xAAAAAAAA) >>> 1));
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        return (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
    }
}
