public class Solution {
    public int findMin(int[] num) {
        if(num.length == 1) return num[0];
        if(num.length == 2) return Math.min(num[0], num[1]);
        if(num[0] < num[num.length -1]) return num[0];
        int mid = num.length / 2;
        if(num[mid] > num[0]) return findMin(Arrays.copyOfRange(num, mid+1, num.length));
        else return findMin(Arrays.copyOfRange(num, 0, mid+1));
    }
}
/*
class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        if not num or len(num)==0:
            return
        if len(num) == 1:
            return num[0]
        if len(num) == 2:
            return min(num)
        if num[0] < num[-1]:
            return num[0]
        mid = len(num) / 2
        if num[mid] > num[0]:
            return self.findMin(num[mid+1:])
        else:
            return self.findMin(num[:mid+1])
*/
