public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||b==null) return null;
        a=a.trim();
        b=b.trim();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0&&j>=0) {
            int ai=Integer.valueOf(a.charAt(i)-'0');
            int bj=Integer.valueOf(b.charAt(j)-'0');
            sb.append((ai+bj+carry)%2);
            carry=(ai+bj+carry)/2;
            i--;
            j--;
        }
        while(i>=0){
            int ai=Integer.valueOf(a.charAt(i)-'0');
            sb.append((ai+carry)%2);
            carry=(ai+carry)/2;
            i--;
        }
        while(j>=0){
            int bj=Integer.valueOf(b.charAt(j)-'0');
            sb.append((bj+carry)%2);
            carry=(bj+carry)/2;
            j--;
        }
        if(carry>0) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
}
