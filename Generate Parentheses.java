import java.util.*;
public class Solution {
    public List<String> generateParenthesis(int n) {
        /*
            def generateParenthesis(self, n):
                s = set()
                if n<=0:
                    return []
                if n==1:
                    return ['()']
                for p in self.generateParenthesis(n-1):
                    for i in range(len(p)+1):
                        s.add(p[:i]+'()'+p[i:])
                return list(s)
        */
        Set<String> s = new HashSet<String>();
        List<String> r = new ArrayList<String>();
        if(n<=0) return r;
        if(n==1) {
            r.add("()");
            return r;
        }
        for(String p : generateParenthesis(n-1)) {
            for(int i=0; i<p.length()+1; i++) {
                s.add(p.substring(0,i)+"()"+p.substring(i));
            }
        }
        return new ArrayList<String>(s);
    }
}
