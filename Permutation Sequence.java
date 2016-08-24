import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i<10; i++) {
            fact[i] = fact[i-1] * i;
        }
        k--;
        List<Integer> s = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) s.add(i);
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<n; i++) {
            int a = k/fact[n-1-i];
            ret.append(String.valueOf(s.get(a)));
            s.remove(Integer.valueOf(s.get(a)));
            k %= fact[n-1-i];
        }
        return ret.toString();
    }
}

/*
    def getPermutation(self, n, k):
        fact = [1]
        for i in range(1, 10):
            fact.append(fact[-1] * i)
        k -= 1
        s = [i+1 for i in range(n)]
        ret = []
        for i in range(n):
            a = k / fact[n - 1 - i]
            ret.append(str(s[a]))
            s.remove(s[a])
            k %= fact[n - 1 - i]
        return ''.join(ret)
*/
