public class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int sum = size; //give 1 candy to each child first
        int range = 0;
        for (int i = 0; i < size - 1; ) {
            int start = i;
            while (i < size - 1 && ratings[i] < ratings[i + 1]) i++; // /
            range = i - start;
            sum += (range * (range + 1)) / 2;
            
            start = i;
            while (i < size - 1 && ratings[i] > ratings[i + 1]) i++; // \
            int k = i - start - 1;
            sum += (k * (k + 1)) / 2;
            
            if (i - start > range) sum += i - start - range;
            if (i < size - 1 && ratings[i] == ratings[i + 1]) i++;
        }
        return sum;
    }
}
