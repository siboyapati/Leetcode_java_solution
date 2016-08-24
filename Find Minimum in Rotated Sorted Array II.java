public class Solution {
    public int findMin(int[] num) {
        if(num.length==1) return num[0];
        if(num.length==2) return Math.min(num[0], num[1]);
        int mid = num.length / 2;
        if(num[0] < num[num.length-1])
            return num[0];
        else if(num[0] == num[num.length-1]) {
            if(num[mid] > num[0]) return findMin(Arrays.copyOfRange(num, mid+1, num.length));
            else if(num[mid]<num[0]) return findMin(Arrays.copyOfRange(num, 0, mid+1));
            else return Math.min(findMin(Arrays.copyOfRange(num, mid+1, num.length)), findMin(Arrays.copyOfRange(num, 0, mid+1)));
        } else {
            if(num[mid] >= num[0]) return findMin(Arrays.copyOfRange(num, mid+1, num.length));
            else return findMin(Arrays.copyOfRange(num, 0, mid+1));
        }
    }
}
/*
class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        # yes this will affect the run time complexity.
        # eg. consider an array with m 1s in the front, then a 0,
        # then n 1s in the end. to find the 0 we need to check every
        # number and the run time complexity will be O(n)

        if len(num) <= 2:
            return min(num)
        mid = len(num) // 2
        if num[0] < num[-1]:
            return num[0]
        elif num[0] == num[-1]:
            if num[mid] > num[0]:
                return self.findMin(num[mid+1:])
            elif num[mid] < num[0]:
                return self.findMin(num[:mid+1])
            else:
                return min(self.findMin(num[mid+1:]), self.findMin(num[:mid+1]))
        else:
            if num[mid] >= num[0]:
                return self.findMin(num[mid+1:])
            else:
                return self.findMin(num[:mid+1])
*/
