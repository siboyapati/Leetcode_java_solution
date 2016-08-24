public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n >>> 16) & 0x0000ffff) | ((n << 16) & 0xffff0000);
        n = ((n >>> 8) & 0x00ff00ff) | ((n << 8) & 0xff00ff00);
        n = ((n >>> 4) & 0x0f0f0f0f) | ((n << 4) & 0xf0f0f0f0);
        n = ((n >>> 2) & 0x33333333) | ((n << 2) & 0xcccccccc);
        return ((n >>> 1) & 0x55555555) | ((n << 1) & 0xaaaaaaaa);
    }
}
