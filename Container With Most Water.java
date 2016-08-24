public class Solution {
    public int maxArea(int[] height) {
        /*
        def maxArea(self, height):
            ret=0
            i,j=0,len(height)-1
            while i<j:
                if height[i]<=height[j]:
                    ret = max(ret, (j-i)*height[i])
                    i+=1
                else:
                    ret = max(ret, (j-i)*height[j])
                    j-=1
            return ret
        */
        int ret=0;
        int i=0, j=height.length-1;
        while(i<j) {
            if(height[i]<=height[j]) {
                ret = Math.max(ret, (j-i)*height[i]);
                i++;
            }else{
                ret = Math.max(ret, (j-i)*height[j]);
                j--;
            }
        }
        return ret;
    }
}
