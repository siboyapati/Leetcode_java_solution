import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        for(int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if(!isOperator(t)) stack.push(t);
            else {
                try {
                    int b = Integer.valueOf(stack.pop());
                    int a = Integer.valueOf(stack.pop());
                    stack.push(calc(a, b, t));
                } catch(Exception e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if(stack.size() != 1) throw new IllegalArgumentException();
        
        try {
            int r = Integer.valueOf(stack.pop());
            return r;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    
    private String calc(int a, int b, String op) {
        switch(op.charAt(0)) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if(b==0) throw new IllegalArgumentException();
                else return String.valueOf(a / b);
        }
        throw new IllegalArgumentException();
    }
    
    private boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
