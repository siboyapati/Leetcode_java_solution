public class Solution {
    public boolean isHappy(int n) {
        if(n<=0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while(n>1) {
            if(set.contains(n)) return false;
            set.add(n);
            int t = 0;
            while (n>0) {
                t += (n%10) * (n%10);
                n /= 10;
            }
            n = t;
        }
        return true;
    }
}
