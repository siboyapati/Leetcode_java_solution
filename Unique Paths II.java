public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        int[][] r = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) r[i][j] = -1;
        }
        return calc(obstacleGrid, 0, 0, r);
    }
    private int calc(int[][] g, int i, int j, int[][] r) {
        if(r[i][j] >= 0) return r[i][j];
        if(i==g.length-1 && j==g[0].length-1) {
            if(g[i][j]==1) r[i][j] = 0;
            else r[i][j] = 1;
        } else if(i==g.length-1) {
            if(g[i][j]==1) r[i][j] = 0;
            else r[i][j] = calc(g, i, j+1, r);
        } else if(j==g[0].length-1) {
            if(g[i][j]==1) r[i][j] = 0;
            else r[i][j] = calc(g, i+1, j, r);
        } else {
            if(g[i][j]==1) r[i][j] = 0;
            else r[i][j] = calc(g, i, j+1, r) + calc(g, i+1, j, r);
        }
        return r[i][j];
    }
}
