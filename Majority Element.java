public class Solution {
    public int majorityElement(int[] num) {
        assert num!=null && num.length>0;
        int retval = num[0];
        int cnt = 1;
        for(int i=1; i<num.length; i++) {
            if(num[i]==retval) cnt++;
            else {
                if(cnt>1) cnt--;
                else {
                    i++;
                    retval=num[i];
                    cnt=1;
                }
            }
        }
        return retval;
    }
}
