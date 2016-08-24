public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int currentMinLen = 0;
        int i = 0;
        int sum = 0;
        int len = 0;
        while (i < nums.length) {
            sum += nums[i];
            i++;
            if (sum >= s) break;
        }
        if (sum < s) return 0;
        
        len = i;
        currentMinLen = i;
        while (i < nums.length) {
            while (sum >= s) {
                currentMinLen = Math.min(currentMinLen, len);
                sum -= nums[i - len];
                len--;
            }
            sum += nums[i];
            i++;
            len++;
        }
        while (sum >= s) {
            currentMinLen = Math.min(currentMinLen, len);
            sum -= nums[i - len];
            len--;
        }
        
        return currentMinLen;
    }
}
