public class Solution {
    public int maxProduct(int[] A) {
        return maxProduct1(A, 0, A.length-1);
    }
    private int maxProduct1(int[] A, int m, int n) {
        if(n<m) return 0;
        if(m==n) return A[m];
        int p=1;
        for(int i=m; i<=n; i++) {
            if(A[i]==0) {
                int r = Math.max(maxProduct1(A, m, i-1), maxProduct1(A,i+1,n));
                return r>0?r:0;
            }
            else p*=A[i]; 
        }
        if(p>0) return p;
        int p1=p,p2=p;
        for(int i=m;i<=n;i++) {
            if(p1>0) break;
            else p1/=A[i];
        }
        for(int i=n;i>=m; i--) {
            if(p2>0) break;
            else p2/=A[i];
        }
        return Math.max(p1,p2);
    }
}
/*
def maxProduct(self, A):
        if len(A)==0:
            return 0
        if len(A)==1:
            return A[0]
        p=1
        for i in range(len(A)):
            if A[i]==0:
                return max(self.maxProduct(A[:i]), self.maxProduct(A[(i+1):]), 0)
            else:
                p*=A[i]
        if p>0:
            return p
        p1=p
        for a in A:
            if p1>0:
                break
            else:
                p1/=a
        p2=p
        for i in range(len(A)-1,-1,-1):
            if p2>0:
                break
            else:
                p2/=A[i]
        return max(p1,p2)
*/
