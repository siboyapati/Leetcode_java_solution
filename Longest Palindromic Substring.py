class Solution:
    # @return a string
    def longestPalindrome(self, s):
        maxp=''
        for i in range(len(s)):
            j=1
            while j<len(s):
                if i-j<0 or i+j>=len(s) or s[i-j]!=s[i+j]:
                    break
                j+=1
            if 2*j-1>len(maxp):
                maxp = s[i-j+1:i+j]
        for i in range(len(s)-1):
            if s[i]==s[i+1]:
                j=1
                while j<len(s):
                    if i-j<0 or i+1+j>=len(s) or s[i-j]!=s[i+1+j]:
                        break
                    j+=1
                if 2*j>len(maxp):
                    maxp=s[i-j+1:i+1+j]
        return maxp
