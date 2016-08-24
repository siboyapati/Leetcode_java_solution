import java.util.*;
public class Solution {
    public List<String> letterCombinations(String digits) {
        /*
            def letterCombinations(self, digits):
                if len(digits)==0:
                    return ['']
                dic = dict([('2', 'abc'), ('3', 'def'), ('4', 'ghi'), ('5', 'jkl'), \
                            ('6', 'mno'), ('7', 'pqrs'), ('8', 'tuv'), ('9', 'wxyz')])
                for d in digits:
                    if not dic.keys().__contains__(d):
                        return []
                return [c+s for c in dic[digits[0]] for s in self.letterCombinations(digits[1:])]
        */
        List<String> r = new ArrayList<String>();
        if(digits.length()==0) {
            r.add("");
            return r;
        }
        HashMap<String, String> dic = new HashMap<String,String>();
        dic.put("2", "abc"); dic.put("3", "def"); dic.put("4", "ghi"); dic.put("5", "jkl");
        dic.put("6", "mno"); dic.put("7", "pqrs"); dic.put("8", "tuv"); dic.put("9", "wxyz");
        for(int i=0; i<digits.length(); i++) {
            if(!dic.keySet().contains(String.valueOf(digits.charAt(i)))) return r;
        }
        String s0 = dic.get(digits.substring(0,1));
        for(int i = 0; i < s0.length(); i++) {
            for(String s : letterCombinations(digits.substring(1))) {
                r.add(String.valueOf(s0.charAt(i)) + s);
            }
        }
        return r;
    }
}
