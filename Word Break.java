import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        /*
            def wordBreak(self, s, dict):
                d={}
                d[len(s)]=True
                d[len(s)-1]=dict.__contains__(s[-1])
                for i in range(len(s)-2,-1,-1):
                    found=False
                    for j in range(i+1,len(s)+1):
                        if dict.__contains__(s[i:j]) and d[j]:
                            found=True
                            break
                    d[i]=found
                return d[0]
        */
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        dp[s.length()-1] = dict.contains(s.substring(s.length()-1));
        for (int i=s.length()-2; i>=0; i--) {
            boolean found = false;
            for(int j=i+1; j<=s.length(); j++) {
                if(dict.contains(s.substring(i,j)) && dp[j]) {
                    found = true;
                    break;
                }
            }
            dp[i] = found;
        }
        return dp[0];
    }
}
