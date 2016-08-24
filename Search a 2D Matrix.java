import java.util.Arrays;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int ra=0, rb=matrix.length-1, r=-1;
        while(ra < rb) {
            int rm = (ra + rb) / 2;
            if(matrix[rm][0] > target) rb = rm - 1;
            else if(matrix[rm][matrix[rm].length-1] < target) ra = rm + 1;
            else {
                r = rm;
                break;
            }
        }
        r = r<0 ? ra : r;
        return Arrays.binarySearch(matrix[r], target) >= 0;
    }
}
