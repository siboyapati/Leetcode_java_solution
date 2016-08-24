public class Solution {
    public int jump(int[] A) {
        /*
            def jump(self, A):
                dp={}
                dp[len(A)-1]=0
                for i in range(len(A)-2,-1,-1):
                    if A[i]==A[i+1]+1 and i+1!=len(A)-1:
                        dp[i]=dp[i+1]
                    else:
                        minjmp=0x7fffffff
                        for j in range(1,A[i]+1):
                            if i+j<len(A) and dp[i+j]+1<minjmp:
                                minjmp=dp[i+j]+1
                        dp[i]=minjmp
                return dp[0]
        */
        int[] dp = new int[A.length];
        dp[A.length-1] = 0;
        for(int i=A.length-2; i>=0; i--) {
            if(A[i]==A[i+1]+1 && i+1!=A.length-1) dp[i]=dp[i+1];
            else {
                int minJump = 0x7fffffff;
                for(int j=1; j<=A[i]; j++) {
                    if(i+j<A.length && dp[i+j]!=0x7fffffff && dp[i+j]+1<minJump) minJump=dp[i+j]+1;
                }
                dp[i]=minJump;
            }
        }
        return dp[0];
    }
}
