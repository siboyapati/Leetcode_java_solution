public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<=0) return new int[0][0];
        int[][] mtx = new int[n][n];
        fill(mtx, 0, n-1, 1);
        return mtx;
    }
    private void fill(int[][] mtx, int a, int b, int v) {
        if(a>b) return;
        if(a==b) {
            mtx[a][a]=v;
            return;
        }
        for(int j=a;j<b;j++) mtx[a][j] = v++;
        for(int i=a;i<b;i++) mtx[i][b] = v++;
        for(int j=b;j>a;j--) mtx[b][j] = v++;
        for(int i=b;i>a;i--) mtx[i][a] = v++;
        fill(mtx, a+1, b-1, v);
    }
}
