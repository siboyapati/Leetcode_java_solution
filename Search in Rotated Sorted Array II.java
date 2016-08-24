public class Solution {
    public boolean search(int[] A, int target) {
        return s0(A, 0, A.length, target);
    }
    private boolean s0(int[] A, int i, int j, int t) {
        if(j<=i) return false;
        if(j==i+1) return A[i]==t;
        int mid = (i+j)/2;
        /*
            A[i] < A[mid]:
                t<A[i] || A[mid]<t:
                    return s0(A, mid+1,j,t)
                t==A[i]:
                    return true
                A[i]<t<A[mid]:
                    return s0(A, i, mid, t)
                t==A[mid]:
                    return true
            A[i] == A[mid]:
                if A[i]==t:
                    return true
                return s0(A,i+1,mid,t) || s0(A,mid+1,j,t)
            A[i] > A[mid]:
                t<A[mid] || A[i]<t:
                    return s0(A, i, mid, t)
                t==A[mid]:
                    return true
                A[mid]<t<A[i]:
                    return s0(A, mid+1, j, t)
                t==A[i]:
                    return true
        */
        if(A[i]==t || A[mid]==t) return true;
        
        if(A[i]<A[mid]) {
            if(t<A[i] || A[mid]<t) return s0(A, mid+1, j, t);
            else return s0(A, i, mid, t);
        } else if(A[i] == A[mid]) return s0(A, i+1, mid, t) || s0(A, mid+1, j, t);
        else {
            if(t<A[mid] || A[i]<t) return s0(A, i, mid, t);
            else return s0(A, mid+1, j, t);
        }
    }
}
