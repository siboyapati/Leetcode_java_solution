import java.util.ArrayDeque;

public class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        
        boolean afterSpace = false;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                if(!afterSpace) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                    afterSpace = true;
                }
            } else {
                stack.push(c);
                afterSpace = false;
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
    }
}
