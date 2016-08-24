public class Solution {
    public int[] plusOne(int[] digits) {
        /*
            carry = 1
            for i in [digits.length-1, 0]:
                sum = digits[i] + carry
                digits[i] = sum % 10
                carry = sum / 10
            if carry==0:
                return digits
            else:
                return digits.left_append carry
        */
        int c = 1;
        for(int i = digits.length-1; i>=0; i--){
            int sum = digits[i] + c;
            digits[i] = sum % 10;
            c = sum / 10;
        }
        if(c==0) return digits;
        else {
            int[] r = new int[digits.length+1];
            r[0]=c;
            System.arraycopy(digits, 0, r, 1, digits.length);
            return r;
        }
    }
}
