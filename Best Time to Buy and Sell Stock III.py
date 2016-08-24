class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        maxp=0
        for i in range(len(prices)+1):
            pl=prices[:i]
            pr=prices[i:]
            maxp=max(maxp,self.f(pl)+self.f(pr))
        return maxp
    def f(self,prices):
        if len(prices)<2:
            return 0
        cmin=prices[0]
        pmin=[]
        for i in range(len(prices)):
            if prices[i]<cmin:
                cmin=prices[i]
            pmin.append(cmin)
        cmax=prices[-1]
        pmax=[]
        for i in range(len(prices)-1,-1,-1):
            if prices[i]>cmax:
                cmax=prices[i]
            pmax.append(cmax)
        pmax.reverse()
        r=pmax[0]-pmin[0]
        for i in range(len(prices)):
            r=max(r,pmax[i]-pmin[i])
        return r
