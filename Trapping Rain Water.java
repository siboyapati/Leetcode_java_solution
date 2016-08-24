public class Solution {
    public int trap(int[] A) {
        /*
            def trap(self, A):
                maxIndex=0
                for i in range(len(A)):
                    if A[i]>A[maxIndex]:
                        maxIndex=i
                w=0
                startIndex=0
                for i in range(1,maxIndex+1):
                    if A[i]<=A[startIndex]:
                        w+=A[startIndex]-A[i]
                    else:
                        startIndex=i
                startIndex=len(A)-1
                for i in range(len(A)-1,maxIndex-1,-1):
                    if A[i]<=A[startIndex]:
                        w+=A[startIndex]-A[i]
                    else:
                        startIndex=i
                return w
        */
        int maxIndex = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i]>A[maxIndex]) maxIndex=i;
        }
        int w=0;
        int startIndex = 0;
        for(int i=1; i<=maxIndex; i++) {
            if(A[i]<=A[startIndex]) w+=A[startIndex]-A[i];
            else startIndex = i;
        }
        startIndex=A.length-1;
        for(int i=A.length-2; i>=maxIndex; i--) {
            if(A[i]<=A[startIndex]) w+=A[startIndex]-A[i];
            else startIndex = i;
        }
        return w;
    }
}
