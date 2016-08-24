public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length()!=t.length()) return false;
        int[] arrs = new int[26];
        int[] arrt = new int[26];
        for(int i=0; i<26; i++) {
            arrs[i]=0;
            arrt[i]=0;
        }
        for(int i=0; i<s.length();i++) {
            arrs[s.charAt(i)-'a'] += 1;
            arrt[t.charAt(i)-'a'] += 1;
        }
        for(int i=0; i<26; i++) {
            if(arrs[i]!=arrt[i]) return false;
        }
        return true;
    }
}
