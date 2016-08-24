public class Solution {
    public String intToRoman(int num) {
        /*
            I 1
            V 5
            X 10
            L 50
            C 100
            D 500
            M 1000
        */
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        int[] ks = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0; i<ks.length; i++) {
            while(num >= ks[i]) {
                num -= ks[i];
                sb.append(map.get(ks[i]));
            }
        }
        return sb.toString();
    }
}
