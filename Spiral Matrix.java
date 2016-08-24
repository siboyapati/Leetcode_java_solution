import java.util.*;
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<Integer>();
        return spiral(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    private List<Integer> spiral(int[][] mtx, int a, int b, int c, int d) {
        List<Integer> r = new ArrayList<Integer>();
        if(c<a || d<b) return r;
        if(a==c) {
            for(int j=b; j<=d; j++) r.add(mtx[a][j]);
            return r;
        }
        if(b==d) {
            for(int i=a; i<=c; i++) r.add(mtx[i][b]);
            return r;
        }
        
        for(int j=b; j<d; j++) r.add(mtx[a][j]);
        for(int i=a; i<c; i++) r.add(mtx[i][d]);
        for(int j=d; j>b; j--) r.add(mtx[c][j]);
        for(int i=c; i>a; i--) r.add(mtx[i][b]);
        
        r.addAll(spiral(mtx,a+1,b+1,c-1,d-1));
        return r;
    }
}
