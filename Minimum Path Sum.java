public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return -1;
        int[][] r = new int[grid.length][grid[0].length];
        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) r[i][j] = -1;
        }
        return calc(grid, 0, 0, r);
    }
    private int calc(int[][] g, int i, int j, int[][] r) {
        if(r[i][j] >= 0) return r[i][j];
        if(i==g.length-1 && j==g[0].length-1) r[i][j] = g[i][j];
        else if(i==g.length-1) r[i][j] = calc(g, i, j+1, r) + g[i][j];
        else if(j==g[0].length-1) r[i][j] = calc(g, i+1, j, r) + g[i][j];
        else r[i][j] = Math.min(calc(g, i, j+1, r), calc(g, i+1, j, r)) + g[i][j];
        return r[i][j];
    }
}
