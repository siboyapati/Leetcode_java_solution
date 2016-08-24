public class Solution {
    public int removeElement(int[] A, int elem) {
        /*
            i,j=0,A.length-1
            while i<j:
                if A[i]!=elem:
                    i++
                else if A[j]==elem:
                    j--
                else:
                    swap A[i], A[j]
                    i++
                    j--
            if j<i:
                return j+1
            else: #j==1
                if A[i]==elem:
                    return i
                else:
                    return i+1
            
            test:
                [] 0
                [0 0 0] 0
                [1 0 0] 0
        */
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] != elem) i++;
            else if (A[j] == elem) j--;
            else {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j--;
            }
        }
        if (j < i) return j + 1;
        else {
            if (A[i] == elem) return i;
            else return i + 1;
        }
    }
}
