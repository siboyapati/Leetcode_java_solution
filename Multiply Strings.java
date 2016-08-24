public class Solution {
    public String multiply(String num1, String num2) {
        /*
            assume both are non-negative integral numbers
            if num1.length<num2.length:
                return multiply(num2, num1)
            string prod
            for i in [0..num2.length-1]:
                prod = add(prod, multiply0(num1, num2[i])+"0"*(num2.length-i))
            return prod
            
            time O(m*n) space O(m+n)
        */
        if(num1==null||num2==null) return null;
        if(num1.length()==0||num2.length()==0) return "";
        if(num1.length()<num2.length()) return multiply(num2, num1);
        
        StringBuilder prod = new StringBuilder();
        for(int i=0; i<num2.length(); i++) {
            StringBuilder p = multiply0(num1, num2.charAt(i));
            for(int j=0; j<num2.length()-1-i; j++) p.append("0");
            prod = add(prod, p);
        }
        String r = prod.toString();
        if(r.length()>0 && r.charAt(0)=='0') return "0";
        return r;
    }
    private StringBuilder multiply0(String s, char a) {
        StringBuilder r = new StringBuilder();
        int carry = 0;
        for(int i = s.length()-1; i>=0; i--) {
            char b = s.charAt(i);
            int p = ((int)a - (int)('0')) * ((int)b - (int)('0'));
            r.append(String.valueOf((p+carry)%10));
            carry = (p + carry) / 10;
        }
        if(carry!=0) r.append(String.valueOf(carry));
        r.reverse();
        return r;
    }
    private StringBuilder add(StringBuilder a, StringBuilder b) {
        StringBuilder r = new StringBuilder();
        int carry = 0;
        a.reverse();
        b.reverse();
        String sa = a.toString();
        String sb = b.toString();
        if(sb.equals("")) return a;
        if(sa.length()<sb.length()) return add(b, a);
        int i = 0, j = 0;
        while(j < sb.length()) {
            int sum = (int)(sa.charAt(i))-(int)'0' + (int)(sb.charAt(j))-(int)'0';
            r.append((sum+carry)%10);
            carry = (sum+carry) / 10;
            i++;
            j++;
        }
        while(i < sa.length()) {
            r.append(((int)(sa.charAt(i))-(int)'0'+carry)%10); 
            carry = ((int)(sa.charAt(i))-(int)'0'+carry) / 10;
            i++;
        }
        if(carry!=0) r.append(carry);
        r.reverse();
        return r;
    }
}
