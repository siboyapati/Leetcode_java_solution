/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        /*
        def maxPoints(self, points):
            if len(points)<=2:
                return len(points)
            m=2
            for i in range(len(points)):
                cnt=1
                ratios=[]
                for j in range(i+1,len(points)):
                    if points[i].x==points[j].x and points[i].y==points[j].y:
                        cnt+=1
                    else:
                        ratios.append(self.calc_r(points[i], points[j]))
                m=max(m, self.max_similar(ratios)+cnt)
            return m
        def calc_r(self, a, b):
            if a.x==b.x:
                return math.atan(1<<100)
            return math.atan((a.y-b.y)*1.0/(a.x-b.x))
        def max_similar(self, rs):
            rs.sort()
            if len(rs)<=1:
                return len(rs)
            m=1
            cur=1
            for i in range(1,len(rs)):
                if abs(rs[i]-rs[i-1])<=1e-7:
                    cur+=1
                    m=max(m,cur)
                else:
                    cur=1
            return m
        */
        if(points.length<=2) return points.length;
        int m=2;
        for(int i=0; i<points.length; i++) {
            int cnt=1;
            ArrayList<Double> ratios= new ArrayList<Double>();
            for(int j=i+1;j<points.length;j++) {
                if(points[i].x==points[j].x && points[i].y==points[j].y) cnt++;
                else ratios.add(calcRatio(points[i], points[j]));
            }
            m = Math.max(m, maxSimilar(ratios.toArray(new Double[ratios.size()]))+cnt);
        }
        return m;
    }
    private double calcRatio(Point a, Point b) {
        if(a.x==b.x) return Math.atan(0x7fffffffffffffffL);
        return Math.atan((a.y-b.y)*1.0/(a.x-b.x));
    }
    private int maxSimilar(Double[] rs) {
        Arrays.sort(rs);
        if(rs.length<=1) return rs.length;
        int m=1, cur=1;
        for(int i=1; i<rs.length; i++) {
            if(Math.abs(rs[i]-rs[i-1])<1e-7) {
                cur++;
                m=Math.max(m,cur);
            } else cur=1;
        }
        return m;
    }
}
