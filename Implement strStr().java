public class Solution {
    public String strStr(String haystack, String needle) {
        String h = haystack, n = needle;
        if(h==null || n==null) return null;
        if(h.length()<n.length()) return null;
        if(n.equals("")) return h;
        for(int i=0; i<=h.length()-n.length(); i++) {
             boolean match = true;
             for(int j=0; j<n.length(); j++) {
                 if(h.charAt(i+j)!=n.charAt(j)){
                     match=false;
                     break;
                 }
             }
             if(match) return h.substring(i);
        }
        return null;
    }
}
