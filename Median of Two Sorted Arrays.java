import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int sum = A.length + B.length;
        if(sum % 2 == 0) return (fk(A, 0, B, 0, sum / 2) + fk(A, 0, B, 0, sum / 2 - 1)) / 2.0;
        else return fk(A, 0, B, 0, sum / 2) * 1.0;
    }
    private int fk(int[] A, int ia, int[] B, int ib, int k) {
        if (A.length - ia < B.length - ib) return fk(B, ib, A, ia, k);
        if (B.length == ib) return A[ia + k];
        if (k <= 3) {
            int i = 0;
            int[] C = new int[k+1];
            while(i <= k) {
                if(ia < A.length && ib < B.length) {
                    if(A[ia] <= B[ib]) C[i++] = A[ia++];
                    else C[i++] = B[ib++];
                } else if(ia < A.length) {
                    C[i++] = A[ia++];
                } else if(ib < B.length) {
                    C[i++] = B[ib++];
                } else {
                    assert false : "wrong input.";
                }
            }
            return C[k];
        }
        int m = B.length - ib > k/2-1 ? k/2-1 : B.length - ib - 1;
        if(B[ib + m] < A[ia + k/2-1]) {
            return fk(A, ia, B, m+1 + ib, k-m-1);
        } else {
            return fk(A, ia + k/2, B, ib, k-k/2);
        }
    }
}

/*
    def findMedianSortedArrays(self, A, B):
        s=len(A)+len(B)
        if s%2==0:
            return (self.fk(A,B,s/2)+self.fk(A,B,s/2-1))/2.0
        else:
            return self.fk(A,B,s/2)*1.0
    def fk(self, A, B, k):
        if len(A)<len(B):
            return self.fk(B,A,k)
        if len(B)==0:
            return A[k]
        if k<=3:
            if len(B)<=4:
                C=B[:]
            else:
                C=B[:4]
            if len(A)<=4:
                C+=A
            else:
                C+=A[:4]
            C.sort()
            return C[k]
        if len(B)>k/2-1:
            m=k/2-1
        else:
            m=len(B)-1
        if B[m]<A[k/2-1]:
            return self.fk(A,B[m+1:],k-m-1)
        else:
            return self.fk(A[k/2:],B,k-k/2)
        
*/
