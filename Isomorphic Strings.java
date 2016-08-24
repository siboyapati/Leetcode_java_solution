public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || s.length()<=1) return true;
        
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        for(int i=0;i<s.length();i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map1.containsKey(tc) && map1.get(tc)!=sc || map2.containsKey(sc) && map2.get(sc)!=tc) {
                return false;
            } else {
                map1.put(tc, sc);
                map2.put(sc, tc);
            }
        }
        return true;
    }
}
