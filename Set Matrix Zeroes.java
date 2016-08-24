public class Solution {
    public void setZeroes(int[][] matrix) {
        /*
            matrix==null || matrix.len==0 || matrix[0].len==0
            check if first row has 0
            check if first col has 0
            for i in [1..m-1]:
                for j in [1..n-1]:
                    if matrix[i][j]==0:
                        matrix[i][0]=0
                        matrix[0][j]=0
            for i in [1..m-1]:
                if matrix[i][0]=0:
                    for j in [1..n-1]:
                        matrix[i][j]=0
            for j in [1..n-1]:
                if matrix[0][j]==0:
                    for i in [1..m-1]:
                        matrix[i][j]=0
            if first row has 0 before changes:
                set all elem in first row to 0
            if first col has 0 before changes:
                set all elem in first col to 0
            
            time O(n^2) space O(1)
        */
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        boolean row1has0 = false;
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[0][j]==0) {
                row1has0 = true;
                break;
            }
        }
        boolean col1has0 = false;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0]==0) {
                col1has0 = true;
                break;
            }
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j=0; j<matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i=0; i<matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row1has0) {
            for(int j=0; j<matrix[0].length; j++) matrix[0][j] = 0;
        }
        if(col1has0) {
            for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }
    }
}
