public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
            obviously we can use dp which takes O(n^2) space
            since once we move 1 row down we do not need to save
            results for the numbers in the rows above so we can
            optimize space complexity to O(n)
        */
        if(triangle==null || triangle.size()==0) return -1;
        int[] r1 = new int[triangle.size()];
        int[] r2 = new int[triangle.size()];
        r1[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                if(j==0) r2[0]=r1[0]+triangle.get(i).get(0);
                else if(j==triangle.get(i).size()-1) {
                    r2[j]=r1[j-1]+triangle.get(i).get(j);
                }else {
                    r2[j]=Math.min(r1[j-1], r1[j])+triangle.get(i).get(j);
                }
            }
            System.arraycopy(r2, 0, r1, 0, i+1);
        }
        int min = r1[0];
        for(int i=1; i< r1.length; i++) min = Math.min(min, r1[i]);
        return min;
    }
}
