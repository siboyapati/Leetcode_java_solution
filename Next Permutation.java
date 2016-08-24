public class Solution {
    public void nextPermutation(int[] num) {
        /*
            def nextPermutation(self, num):
                for i in range(len(num)-1,0,-1):
                    if num[i]>num[i-1]:
                        for j in range(len(num)-1,i-1,-1):
                            if num[j]>num[i-1]:
                                num[i-1],num[j]=num[j],num[i-1]
                                break
                        k=0
                        while i+k<len(num)-1-k:
                            num[i+k],num[len(num)-1-k]=num[len(num)-1-k],num[i+k]
                            k+=1
                        return num
                num.sort()
                return num
        */
        for(int i=num.length-1; i>0; i--) {
            if(num[i]>num[i-1]) {
                for(int j=num.length-1; j>=i; j--) {
                    if(num[j]>num[i-1]) {
                        int t = num[j];
                        num[j]= num[i-1];
                        num[i-1]= t;
                        break;
                    }
                }
                int k=0;
                while(i+k<num.length-1-k) {
                    int t = num[i+k];
                    num[i+k] = num[num.length-1-k];
                    num[num.length-1-k] = t;
                    k++;
                }
                return;
            }
        }
        for(int i=0; i<num.length/2; i++) {
            int t = num[i];
            num[i]=num[num.length-i-1];
            num[num.length-i-1] = t;
        }
    }
}
