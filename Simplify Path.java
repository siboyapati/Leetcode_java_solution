import java.util.ArrayDeque;

public class Solution {
    public String simplifyPath(String path) {
        /*
            test:
                /
                /a
                ///a///a
                /.././
                leading/trailing spaces
                null
        */
        if(path==null||path.length()==0) return path;
        path = path.trim();
        String[] ns = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<String>();
        for(int i=0; i< ns.length; i++) {
            if(ns[i].equals("") || ns[i].equals(".")) ;
            else if(ns[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(ns[i]);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}
