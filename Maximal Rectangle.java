public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        return maximalRectangle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private int maximalRectangle(char[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 == i2 && j1 == j2) return matrix[i1][j1]=='1' ? 1 : 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (matrix[i][j]=='0') {
                    int m1 = maximalRectangle(matrix, i1, j1, i2, j - 1);
                    int m2 = maximalRectangle(matrix, i1, j + 1, i2, j2);
                    int m3 = maximalRectangle(matrix, i1, j1, i - 1, j2);
                    int m4 = maximalRectangle(matrix, i + 1, j1, i2, j2);
                    return Math.max(Math.max(m1, m2), Math.max(m3, m4));
                }
            }
        }
        return (i2 - i1 + 1) * (j2 - j1 + 1);
    }
}
