import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            def lengthOfLongestSubstring(self, s):
                d={}
                start=0
                ret=0
                for i in range(len(s)):
                    c=s[i]
                    if d.__contains__(c) and start<d[c]+1:
                        start=d[c]+1
                    ret = max(ret, i-start+1)
                    d[c]=i
                return ret
        */
        Map<Character,Integer> d = new HashMap<Character,Integer>();
        int start=0,ret=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(d.containsKey(c) && start<d.get(c)+1) start=d.get(c)+1;
            ret = Math.max(ret, i-start+1);
            d.put(c,i);
        }
        return ret;
    }
}
