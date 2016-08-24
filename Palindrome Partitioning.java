public class Solution {
    public List<List<String>> partition(String s) {
        /*
            def partition(self, s):
                ret=[]
                if len(s)==0:
                    return [[]]
                for i in range(1,len(s)+1):
                    if self.isp(s[:i]):
                        for r in self.partition(s[i:]):
                            ret+=[[s[:i]]+r]
                return ret
            def isp(self, s):
                if len(s)==0:
                    return True
                for i in range(len(s)/2):
                    if s[i]!=s[len(s)-1-i]:
                        return False
                return True
        */
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s.length()==0) {
            ret.add(new ArrayList<String>());
            return ret;
        }
        for(int i=1; i<=s.length(); i++) {
            if(isP(s.substring(0,i))) {
                for(List<String> r : partition(s.substring(i))) {
                    r.add(0, s.substring(0,i));
                    ret.add(r);
                }
            }
        }
        return ret;
    }
    private boolean isP(String s) {
        if(s.equals("")) return true;
        for(int i=0; i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
