import java.util.*;
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        /*
            def restoreIpAddresses(self, s):
                return self.f(s, 4)
            def f(self, s, n):
                r = []
                if len(s)==0:
                    return []
                if n==1:
                    r = [s] if self.check(s) else []
                    return r
                for t in self.f(s[1:],n-1):
                    r.append(s[0]+'.'+t)
                if len(s)>=2 and self.check(s[0:2]):
                    for t in self.f(s[2:],n-1):
                        r.append(s[0:2]+'.'+t)
                if len(s)>=3 and self.check(s[0:3]):
                    for t in self.f(s[3:],n-1):
                        r.append(s[0:3]+'.'+t)
                return r
            def check(self, s):
                if len(s)==0:
                    return False
                if len(s)==1:
                    return True
                if s[0]=='0':
                    return False
                return 10<=int(s)<=255
        */
        return f(s, 4);
    }
    private List<String> f(String s, int n) {
        List<String> r = new ArrayList<String>();
        if(s.length()==0) return r;
        if(n==1) {
            if(check(s)) r.add(s);
            return r;
        }
        for(String t : f(s.substring(1), n-1)) r.add(s.substring(0,1)+"."+t);
        if(s.length()>=2 && check(s.substring(0,2))) {
            for(String t: f(s.substring(2), n-1)) r.add(s.substring(0,2)+"."+t);
        }
        if(s.length()>=3 && check(s.substring(0,3))) {
            for(String t: f(s.substring(3), n-1)) r.add(s.substring(0,3)+"."+t);
        }
        return r;
    }
    private boolean check(String s) {
        if(s.length()==0) return false;
        if(s.length()==1) return true;
        if(s.charAt(0)=='0') return false;
        if(s.length()>3) return false;
        int v= Integer.valueOf(s);
        return 10<=v && v<=255;
    }
}
