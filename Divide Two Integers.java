public class Solution {
    public int divide(int dividend, int divisor) {
        /*
            if dr==0:
                throw new IllegalArgumentException();
            sign = (dd>0 && dr<0 || dd<0 && dr>0)? -1:1
            dd = Math.abs(dd)
            dr = Math.abs(dr)
            
            r=0
            while dd>=dr:
                bp=1
                tmp=dr
                while (tmp<<1)>0 && dd>(tmp<<1):
                    tmp<<=1
                    bp<<=1
                dd-=tmp
                r+=bp
                
            return r*sign
        */
        if(divisor==0) throw new IllegalArgumentException();
        int sign = ((dividend>0 && divisor<0) || (dividend<0 && divisor>0))? -1:1;
        long dd = Math.abs((long)dividend);
        long dr = Math.abs((long)divisor);
        
        long r = 0;
        while (dd>=dr) {
            long bp = 1;
            long tmp = dr;
            while((tmp<<1)>0 && dd>(tmp<<1)) {
                tmp <<= 1;
                bp<<=1;
            }
            dd-=tmp;
            r+=bp;
        }
        return (int)(r*sign);
    }
} 
