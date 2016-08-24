public class Solution {
    public int searchInsert(int[] A, int target) {
        return binSearch(A, 0, A.length, target);
    }
    private int binSearch(int[] A, int i, int j, int target) {
        if(j <= i) return j;
        int mid = (i + j) / 2;
        if (A[mid] > target) return binSearch(A, i, mid, target);
        if (A[mid] < target) return binSearch(A, mid + 1, j, target);
        return mid;
    }
    /*
    test
    []
    [1] 1
    [1] 2
    [1] 0
    [1 2] 0
    [1 2 3] 2 
    */
}
