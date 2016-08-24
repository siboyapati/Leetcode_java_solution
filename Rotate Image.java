public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        for(int j=0; j<matrix[0].length; j++) {
            for(int i=0; i<matrix.length/2; i++) {
                //swap matrix[i][j] and matrix[matrix.length-1-i][j]
                int t = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = t;
            }
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<i; j++) {
                //swap matrix[i][j] and matrix[j][i]
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
