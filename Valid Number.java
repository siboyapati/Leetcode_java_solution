public class Solution {
    public boolean isNumber(String s) {
        /*
            null
            trim
            ""
            toLowerCase
            if contains char not in [0..9e.+-]: false
            if more than 1 e: false
            if contains e split to s1 and s2
            if s2 contains .: false
            for s, s1, or s2
            if more than 1 .:false
            if str[0] is - or + remove it
            if str is "" or "." false
            if not all chars are in [0..9.] false
            //if str[0]=='0'&&str[1]!='.': false
        */
        if(s==null) return false;
        s = s.trim();
        if(s.length()==0) return false;
        s = s.toLowerCase();
        HashSet<Character> set = new HashSet<Character>();
        for(String ss : "0123456789e.+-".split("")) {
            if(ss.length()>0) set.add(ss.charAt(0));
        }
        int ecnt=0;
        for(int i=0; i<s.length(); i++) {
            if(!set.contains(s.charAt(i))) return false;
            if(s.charAt(i)=='e') ecnt++;
        }
        if(ecnt>1) return false;
        if(ecnt==0) return check(s);
        else {
            String[] sa = s.split("e");
            if(sa.length<=1) return false;
            for(int i=0; i<sa[1].length(); i++) if(sa[1].charAt(i)=='.') return false;
            return check(sa[0]) && check(sa[1]);
        }
    }
    private boolean check(String s) {
        //[+-]?[0-9]*\.[0-9]
        if(s.length()==0) return false;
        int dotcnt = 0;
        for(int i=0; i<s.length(); i++) if(s.charAt(i)=='.') dotcnt++;
        if(dotcnt>1) return false;
        if(s.charAt(0)=='-' || s.charAt(0)=='+') s = s.substring(1);
        if(s.length()==0 || s.equals(".")) return false;
        HashSet<Character> set = new HashSet<Character>();
        for(String ss : "0123456789.".split("")) {
            if(ss.length()>0) set.add(ss.charAt(0));
        }
        for(int i=0; i<s.length(); i++) {
            if(!set.contains(s.charAt(i))) return false;
        }
        //if(s.length()>1 && s.charAt(0)=='0' && s.charAt(1)!='.') return false;
        return true;
    }
}
