public class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
            def longestCommonPrefix(self, strs):
                if len(strs)==0:
                    return ''
                idx=0
                while idx<len(strs[0]):
                    c = strs[0][idx]
                    for s in strs:
                        if idx>=len(s) or s[idx]!=c:
                            return strs[0][:idx]
                    idx+=1
                return strs[0]
        */
        if(strs.length==0) return "";
        int idx=0;
        while(idx<strs[0].length()) {
            char c = strs[0].charAt(idx);
            for(String s:strs) {
                if(idx>=s.length() || s.charAt(idx)!=c) {
                    return strs[0].substring(0,idx);
                }
            }
            idx++;
        }
        return strs[0];
    }
}
