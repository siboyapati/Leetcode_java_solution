public class Solution {
    public int titleToNumber(String s) {
        int retval = 0;
        for (char c : s.toCharArray()) {
            int v = (int)(c) - (int)('A') + 1;
            retval *= 26;
            retval += v;
        }
        return retval;
    }
}
