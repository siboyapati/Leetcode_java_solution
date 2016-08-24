public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // priority queue time O(n)*log(k), space O(k)
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++) {
            queue.offer(nums[i]);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
}
