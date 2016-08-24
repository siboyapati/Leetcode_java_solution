public class Solution {
    public int reverse(int x) {
        /*
            0xffffffff
            trailing 0s
            overflow
        */
        
        while(x % 10 == 0 && x != 0) x /= 10;
        int sign = x < 0 ? -1 : 1;
        long y = (long)x;
        y *= sign;
        StringBuilder sb = new StringBuilder(String.valueOf(y));
        sb.reverse();
        y = sign * Long.valueOf(sb.toString());
        y = y < 0x80000000 ? 0x80000000 : y;
        y = y > 0x7fffffff ? 0x7fffffff : y;
        return (int)y;
    }
}
