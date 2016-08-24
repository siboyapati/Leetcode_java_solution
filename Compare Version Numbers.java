public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        
        int minLength = Math.min(v1s.length, v2s.length);
        int i = 0;
        for(; i<minLength; i++) {
            int i1 = Integer.valueOf(v1s[i]);
            int i2 = Integer.valueOf(v2s[i]);
            if(i1 > i2) return 1;
            else if(i1 < i2) return -1;
        }
        int sum1 = 0;
        for(int j=0; j<v1s.length; j++) {
            sum1 += Integer.valueOf(v1s[j]);
        }
        int sum2 = 0;
        for(int j=0; j<v2s.length; j++) {
            sum2 += Integer.valueOf(v2s[j]);
        }
        if(sum1 == sum2) return 0;
        return v1s.length > v2s.length? 1:-1;
    }
}

/*
class Solution:
    # @param {string} version1
    # @param {string} version2
    # @return {integer}
    def compareVersion(self, version1, version2):
        v1s = [int(v) for v in version1.split('.')]
        v2s = [int(v) for v in version2.split('.')]
        
        for i in range(min(len(v1s), len(v2s))):
            if v1s[i]>v2s[i]:
                return 1
            elif v1s[i]<v2s[i]:
                return -1
        if len(v1s) > len(v2s):
            if sum(v1s) == sum(v2s):
                return 0
            return 1
        elif len(v1s) < len(v2s):
            if sum(v1s) == sum(v2s):
                return 0
            return -1
        return 0
*/
