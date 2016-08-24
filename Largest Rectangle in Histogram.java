import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        /*
            def largestRectangleArea(self, height):
                '''v1 O(n^2)
                rv=0
                for i in range(len(height)):
                    h=height[i]
                    for j in range(i,len(height)):
                        h=min(h,height[j])
                        rv=max(rv, (j-i+1)*h)
                return rv'''
                
                '''v2 O(nlog(n))
                if len(height)==0:
                    return 0
                if len(height)==1:
                    return height[0]
                min_index=0
                for i in range(1,len(height)):
                    if height[i]<height[min_index]:
                        min_index=i
                left  = self.largestRectangleArea(height[:i])
                right = self.largestRectangleArea(height[(i+1):])
                return max(left, right, height[min_index]*len(height))'''
                
                rv=0
                s=[]
                for h in height:
                    if len(s)==0 or h>=s[-1]:
                        s.append(h)
                    else:
                        w=1
                        while len(s)>0 and s[-1]>h:
                            rv=max(rv, s[-1]*w)
                            w+=1
                            s.pop()
                        for i in range(w):
                            s.append(h)
                w=1
                while len(s)>0:
                    rv=max(rv,s[-1]*w)
                    w+=1
                    s.pop()
                return rv
        */
        int rv = 0;
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        for(int h : height) {
            if(s.isEmpty() || h>=s.peek()) s.push(h);
            else {
                int w = 1;
                while(s.size()>0 && s.peek()>h) {
                    rv = Math.max(rv, s.peek()*w);
                    w++;
                    s.pop();
                }
                while(w-->0) s.push(h);
            }
        }
        int w = 1;
        while(s.size()>0) {
            rv = Math.max(rv, s.peek()*w);
            w++;
            s.pop();
        }
        return rv;
    }
}
