public class Solution {
    public boolean isPalindrome(String s) {
        /*
            def isPalindrome(self, s):
                s=s.strip()
                s=s.lower()
                s=''.join(c for c in s if c.isalnum())
                if len(s)==0:
                    return True
                for i in range(len(s)/2):
                    if s[i]!=s[len(s)-i-1]:
                        return False
                return True
        */
        s = s.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
        }
        s = sb.toString();
        if(s.length()==0) return true;
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
