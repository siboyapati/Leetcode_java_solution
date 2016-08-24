public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        long n=numerator;
        long d=denominator;
        StringBuilder sb = new StringBuilder();
        if(n>0&&d<0 || n<0&&d>0) {
            sb.append("-");
            n = Math.abs(n);
            d = Math.abs(d);
        }
        sb.append(String.valueOf(n/d));
        sb.append(".");
        n %= d;
        int pos = sb.toString().length();
        while(!map.containsKey(n) && n!=0) {
            map.put(n,pos);
            n*=10;
            pos++;
            sb.append(String.valueOf(n/d));
            n %= d;
        }
        String s = sb.toString();
        if(n==0) {
            if(s.charAt(s.length()-1)=='.') s = s.substring(0,s.length()-1);
            return s;
        }
        return s.substring(0,map.get(n)) + "(" + s.substring(map.get(n)) + ")";
    }
}
