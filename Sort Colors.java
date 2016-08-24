public class Solution {
    public void sortColors(int[] A) {
        int[] countTable = new int[3];
        for(int i = 0; i < A.length; i++) {
            countTable[A[i]]++;
        }
        int j = 0;
        for(int i = 0; i < countTable[0]; i++) {
            A[j++] = 0;
        }
        for(int i = 0; i < countTable[1]; i++) {
            A[j++] = 1;
        }
        for(int i = 0; i < countTable[2]; i++) {
            A[j++] = 2;
        }
    }
}
