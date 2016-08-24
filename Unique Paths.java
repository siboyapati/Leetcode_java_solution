public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0) return 0;
        int[][] r = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) r[i][j]=-1;
        }
        return calc(r, 0, 0);
    }
    private int calc(int[][] r, int i, int j) {
        if(r[i][j] >=0) return r[i][j];
        if(i==r.length-1 || j==r[0].length-1) r[i][j]=1;
        else r[i][j] = calc(r, i+1, j) + calc(r, i, j+1);
        return r[i][j];
    }
}
