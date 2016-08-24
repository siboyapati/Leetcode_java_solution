public class Solution {
    public int search(int[] A, int target) {
        return search0(A, 0, A.length, target);
    }
    private int search0(int[] A, int i, int j, int t) {
        /*
            if j<=i:
                return -1;
            mid = (i+j)/2;
            if A[mid]>A[i]:
                if A[i]<=t<A[mid]:
                    return s0(A, i, mid, t)
                else if A[mid]<t || t<A[i]:
                    return s0(A, mid+1, j, t)
                else:
                    return mid
            else: 
                #assert A[mid]<A[i]
                if A[i]<=t || t<A[mid]:
                    return s0(A,i, mid, t)
                else if A[mid]<t<A[i]:
                    return s0(A, mid+1, j, t)
                else:
                    return mid
        */
        
        if(j <= i) return -1;
        if(j == i+1 && A[i]==t) return i;
        int mid = (i + j) / 2;
        if(A[mid] > A[i]) {
            if(A[i]<=t && t<A[mid]) return search0(A, i, mid, t);
            else if(A[mid]<t || t<A[i]) return search0(A, mid+1, j, t);
            else return mid;
        } else {
            if(A[i]<=t || t<A[mid]) return search0(A, i, mid, t);
            else if(A[mid]<t && t<A[i]) return search0(A, mid+1, j, t);
            else return mid;
        }
    }
}
