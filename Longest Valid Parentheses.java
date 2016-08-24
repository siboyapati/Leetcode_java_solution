import java.util.ArrayDeque;

public class Solution {
    public int longestValidParentheses(String s) {
        /*
            def longestValidParentheses(self, s):
            l=[]
            for c in s:
                if c=='(' or len(l)==0:
                    l+=[c]
                elif len(l)==1:
                    if l[0]=='(':
                        l[0]=2
                    else:
                        l+=[c]
                else:
                    if l[-1]==')':
                        l+=[c]
                    elif l[-1]=='(':
                        l[-1]=2
                        if l[-2]!='(' and l[-2]!=')':
                            l[-2]+=2
                            l.pop()
                    else:
                        if l[-2]==')':
                            l+=[c]
                        else:
                            l[-2]=2+l[-1]
                            if len(l)>=3 and l[-3]!='(' and l[-3]!=')':
                                l[-3]+=l[-2]
                                l.pop()
                            l.pop()
            l=[i for i in l if i!='(' and i!=')']
            if len(l)==0:
                return 0
            return max(l)
        */
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(-2); //( -2, ) -1
            else if (stack.size()==0) stack.push(-1);
            else if (stack.size() == 1) {
                if (stack.peek() == -2) {
                    stack.pop();
                    stack.push(2);
                } else stack.push(-1);
            } else {
                if (stack.peek() == -1) stack.push(-1);
                else if (stack.peek() == -2) {
                    stack.pop();
                    if (stack.peek() > 0) {
                        stack.push(stack.pop() + 2);
                    } else {
                        stack.push(2);
                    }
                } else {
                    int top = stack.pop();
                    if (stack.peek() == -2) {
                        stack.pop();
                        if (stack.size() >= 1 && stack.peek() > 0) {
                            stack.push(2 + top + stack.pop());
                        } else stack.push(2 + top);
                    } else {
                        stack.push(top);
                        stack.push(-1);
                    }
                }
            }
        }
        int max = 0;
        while (!stack.isEmpty()) {
            max = Math.max(max, stack.pop());
        }
        return max;
    }
}
