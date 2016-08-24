import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])) {
                for(int j=0; j<i; j++) {
                    if(numbers[i]+numbers[j]==target){
                        return new int[]{j+1, i+1};
                    }
                }
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
