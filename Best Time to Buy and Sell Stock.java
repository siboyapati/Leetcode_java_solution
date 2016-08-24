public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=0) return 0;
        int[] min = new int[prices.length];
        min[0] = prices[0];
        for(int i=1; i<prices.length; i++){
            min[i] = Math.min(min[i-1], prices[i]);
        }
        int[] max = new int[prices.length];
        max[prices.length-1] = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--){
            max[i] = Math.max(max[i+1], prices[i]);
        }
        int r=0;
        for(int i=0; i<prices.length; i++) {
            r = Math.max(r, max[i]-min[i]);
        }
        return r;
    }
}
