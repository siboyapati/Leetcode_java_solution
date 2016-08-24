import java.util.*;
public class Solution {
    public int numDecodings(String s) {
        /*
            def numDecodings(self, s):
                dic={}
                return self.f(s, dic)
            def f(self, s, dic):
                if dic.__contains__(s):
                    return dic[s]
                if len(s)==0 or s[0]=='0':
                    return 0
                if len(s)==1:
                    return 1
                if len(s)==2:
                    if int(s[0:2])<27:
                        r = 1+self.f(s[1], dic)
                    else:
                        r = self.f(s[1], dic)
                    dic[s] = r
                    return r
                if 9<int(s[0:2])<27:
                    r = self.f(s[2:], dic) + self.f(s[1:], dic)
                    dic[s] = r
                    return r
                else:
                    r = self.f(s[1:], dic)
                    dic[s] = r
                    return r
        */
        HashMap<String,Integer> dic = new HashMap<String,Integer>();
        return f(s, dic);
    }
    private int f(String s, HashMap<String,Integer> dic) {
        if(dic.containsKey(s)) return dic.get(s);
        if(s.length()==0 || s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int r = 0;
        try {
            int d2 = Integer.valueOf(s.substring(0,2));
            if(s.length()==2) {
                if(d2<27) r = 1 + f(s.substring(1), dic);
                else r = f(s.substring(1), dic);
                dic.put(s, r);
                return r;
            }
            if (d2 > 9 && d2<27) {
                r = f(s.substring(2), dic) + f(s.substring(1), dic);
                dic.put(s, r);
            } else {
                r = f(s.substring(1), dic);
                dic.put(s, r);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
