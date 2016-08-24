public class Solution {
    public boolean canJump(int[] A) {
        /*
            def canJump(self, A):
                dp={}
                dp[len(A)-1]=True
                for i in range(len(A)-2,-1,-1):
                    if A[i]==A[i+1]+1:
                        dp[i]=dp[i+1]
                        continue
                    canJump=False
                    for j in range(1,A[i]+1):
                        if i+j>=len(A)-1 or dp[i+j]:
                            canJump=True
                            break
                    dp[i]=canJump
                return dp[0]
        */
        boolean[] dp = new boolean[A.length];
        dp[A.length-1] = true;
        for(int i=A.length-2;i>=0;i--){
            if(A[i]==A[i+1]+1) dp[i]=dp[i+1];
            else {
                boolean canJump=false;
                for(int j=1;j<=A[i];j++) {
                    if(i+j>=A.length-1 || dp[i+j]) {
                        canJump=true;
                        break;
                    }
                }
                dp[i]=canJump;
            }
        }
        return dp[0];
    }
}
