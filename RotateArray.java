public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k < 0) k += n;
        
        // int[] copy = new int[n];
        // for (int i = n - k; i < n; i++) {
        //     copy[i - n + k] = nums[i];
        // }
        // for (int i = 0; i < n - k; i++) {
        //     copy[i + k] = nums[i];
        // }
        // for (int i = 0; i < n; i++) {
        //     nums[i] = copy[i];
        // }
        
        
        // int[] doubleNums = new int[2*n];
        // for (int i = 0; i < 2*n; i++) {
        //     doubleNums[i] = nums[i % n];
        // }
        // for (int i = n - k; i < 2 * n - k; i++) {
        //     nums[i - n + k] = doubleNums[i];
        // }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<n-k; i++) {
            stack.push(nums[i]);
        }
        for (int i=n-k; i<n; i++) {
            nums[i-n+k] = nums[i];
        }
        for(int i=n-1; !stack.isEmpty(); i--) {
            nums[i] = stack.pop();
        }
    }
}
