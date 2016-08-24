import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        if(s.length()==0) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') stack.push(c);
            else if(c==')') {
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else return false;
            }
            else if(c==']') {
                if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                else return false;
            }
            else if(c=='}') {
                if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
