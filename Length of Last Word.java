public class Solution {
    public int lengthOfLastWord(String s) {
        /*
            i=s.length()-1
            while i>=0 and s.charAt(i) == ' ':
                i--
            len=0
            while i>=0 and s.charAt(i) != ' ':
                i--
                len++
            return len
            
            test:
            ''
            ' '
            '   '
            '   ss '
            'ss    '
            's'
            ' asd as  assadf  '
            'asdasdasdasd'
        */
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while(i>=0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }
        return len;
    }
}
