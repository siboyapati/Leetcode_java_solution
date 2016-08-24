public class Solution {
    public int[] searchRange(int[] A, int target) {
        /*
            def searchRange(self, A, target):
                i,j=0,len(A)
                while i<j-1:
                    mid=(i+j)/2
                    if A[mid]<target:
                        i=mid
                    elif A[mid]>target:
                        j=mid
                    else:
                        i=mid
                        break
                if A[i]!=target:
                    return [-1,-1]
                a,b=0,i
                while a<b-1:
                    mid=(a+b)/2
                    if A[mid]<target:
                        a=mid
                    else:
                        b=mid
                c,d=i,len(A)-1
                while c<d-1:
                    mid=(c+d)/2
                    if A[mid]>target:
                        d=mid
                    else:
                        c=mid
                if A[a]==target:
                    b=a
                if A[d]==target:
                    c=d
                return [b,c]
        */
        int i=0, j=A.length;
        while(i<j-1) {
            int mid=(i+j)/2;
            if(A[mid]<target) i=mid;
            else if(A[mid]>target) j=mid;
            else { i=mid; break; }
        }
        if(A[i]!=target) return new int[]{-1,-1};
        int a=0,b=i;
        while(a<b-1) {
            int mid = (a+b)/2;
            if(A[mid]<target) a=mid;
            else b=mid;
        }
        int c=i,d=A.length-1;
        while(c<d-1) {
            int mid = (c+d)/2;
            if(A[mid]>target) d=mid;
            else c=mid;
        }
        if(A[a]==target) b=a;
        if(A[d]==target) c=d;
        return new int[]{b,c};
    }
}
