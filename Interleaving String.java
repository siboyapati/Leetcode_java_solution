import java.util.*;
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
            def isInterleave(self, s1, s2, s3):
                d = {}
                return self.f(s1,s2,s3,d)
            def f(self, s1, s2, s3, d):
                if d.__contains__((s1,s2,s3)):
                    return d[(s1,s2,s3)]
                if len(s1)<len(s2):
                    return self.f(s2,s1,s3, d)
                if len(s2)==0:
                    return s1==s3
                if s3[0]!=s1[0] and s3[0]!=s2[0]:
                    return False
                if s1[0]!=s2[0]:
                    if s3[0]==s1[0]:
                        r = self.f(s1[1:],s2,s3[1:], d)
                    else:
                        r = self.f(s1,s2[1:],s3[1:], d)
                    d[(s1,s2,s3)] = r
                    return r
                r = self.f(s1[1:],s2,s3[1:], d) or self.f(s1,s2[1:],s3[1:], d)
                d[(s1,s2,s3)] = r
                return r
        */
        Map<Integer[],Boolean> d = new HashMap<Integer[],Boolean>();
        return f(s1,0,s2,0,s3,0,d);
    }
    private boolean f(String s1, int i1, String s2, int i2, String s3, int i3, Map<Integer[],Boolean> d) {
        Integer[] k = new Integer[]{i1,i2,i3};
        if(d.containsKey(k)) 
            return d.get(k);
        if(s1.length()-i1<s2.length()-i2) 
            return f(s2,i2,s1,i1,s3,i3,d);
        if(s2.length()==i2) 
            return s1.substring(i1).equals(s3.substring(i3));
        if(s3.charAt(i3)!=s1.charAt(i1) && s3.charAt(i3)!=s2.charAt(i2)) 
            return false;
        boolean r = false;
        if(s1.charAt(i1)!=s2.charAt(i2)) {
            if(s3.charAt(i3)==s1.charAt(i1)) r = f(s1,i1+1,s2,i2,s3,i3+1,d);
            else r = f(s1,i1,s2,i2+1,s3,i3+1,d);
            d.put(k,r);
            return r;
        }
        r = f(s1,i1+1,s2,i2,s3,i3+1,d) || f(s1,i1,s2,i2+1,s3,i3+1,d);
        d.put(k,r);
        return r;
    }
}
