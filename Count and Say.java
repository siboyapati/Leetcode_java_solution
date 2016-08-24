import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        /*
            def countAndSay(self, n):
                dic = {1:'1'}
                return self.f(n, dic)
            def f(self, n, dic):
                if dic.__contains__(n):
                    return dic[n]
                r,cnt = '',1
                s = self.f(n-1, dic)
                for i in range(1,len(s)):
                    if i==1 and s[1]!=s[0]:
                        r+='1'+s[0]
                    elif s[i]==s[i-1]:
                        cnt+=1
                    else:
                        r+=str(cnt)+s[i-1]
                        cnt=1
                r+=str(cnt)+s[-1]
                dic[n] = r
                return r
        */
        Map<Integer,String> dic = new HashMap<Integer,String>();
        dic.put(1,"1");
        return f(n, dic);
    }
    private String f(int n, Map<Integer,String> dic) {
        if(dic.containsKey(n)) return dic.get(n);
        String r="";
        int cnt=1;
        String s = f(n-1,dic);
        for(int i=1;i<s.length();i++) {
            if(i==1 && s.charAt(1)!=s.charAt(0)) r+="1"+s.substring(0,1);
            else if(s.charAt(i)==s.charAt(i-1)) cnt++;
            else {
                r+=String.valueOf(cnt)+s.substring(i-1,i);
                cnt=1;
            }
        }
        r+=String.valueOf(cnt)+s.substring(s.length()-1);
        dic.put(n,r);
        return r;
    }
}
