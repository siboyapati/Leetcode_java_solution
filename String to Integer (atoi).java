public class Solution {
    public int atoi(String str) {
        /*
            null
            trim
            ""
            first + -
            first non-digit char, only left
            cut to fit long
            to int
        */
        if(str==null) return 0;
        str = str.trim();
        if(str.length()==0) return 0;
        int sign = str.charAt(0)=='-' ? -1 : 1;
        if(str.charAt(0)=='-' || str.charAt(0)=='+') str = str.substring(1);
        for(int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                str = str.substring(0,i);
                break;
            }
        }
        if(str.length()>11) str = str.substring(str.length()-11);
        if(str.equals("")) return 0;
        long v = Long.valueOf(str);
        if(sign>0 && v>=0x7fffffff) return 0x7fffffff;
        else if(sign<0 && v>=0x0000000080000000L) return 0x80000000;
        else return ((int)v)*sign;
    }
}
