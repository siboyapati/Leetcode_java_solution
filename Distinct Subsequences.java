import java.util.*;

public class Solution {
    public int numDistinct(String S, String T) {
        int m=S.length();
        int n=T.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                if(m-j<n-i || n==i) dp[i][j]=0;
                else if(n-i==1) {
                    int cnt=0;
                    char c = T.charAt(i);
                    for(int k=j;k<m;k++) {
                        if(S.charAt(k)==c) cnt++;
                    }
                    dp[i][j]=cnt;
                } else if(S.charAt(j)==T.charAt(i)) dp[i][j]=dp[i+1][j+1]+dp[i][j+1];
                else dp[i][j]=dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
/*
    def numDistinct(self, S, T):
        d={}
        for i in range(len(T),-1,-1):
            for j in range(len(S),-1,-1):
                S1=S[j:]
                T1=T[i:]
                if len(S1)<len(T1) or len(T1)==0:
                    d[(i,j)]=0
                elif len(T1)==1:
                    d[(i,j)]=S1.count(T1)
                elif S1[0]==T1[0]:
                    d[(i,j)]=d[(i+1),(j+1)]+d[(i,j+1)]
                else:
                    d[(i,j)]=d[(i,j+1)]
        return d[(0,0)]
*/
