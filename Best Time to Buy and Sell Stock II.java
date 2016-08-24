public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int p=0;
        for(int i=1; i<prices.length; i++) {
            p += Math.max(0, prices[i]-prices[i-1]);
        }
        return p;
    }
}
