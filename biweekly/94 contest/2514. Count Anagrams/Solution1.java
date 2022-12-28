import java.util.*;
//------------MATH BINARY EXPONENTIATION

class Solution {
    int MOD = (int) 1e9 + 7;
    int fact[];

    public int countAnagrams(String s) {
        String arr[] = s.split(" ");
        fact = new int[100002];
        fact();
        int ans = 1;
        for (String str : arr) {
            int ways = 1;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }

            ways = fact[str.length()];
            int factR = 1;
            for (char c : map.keySet())
                if (map.get(c) > 1)
                    factR = modmul(factR, fact[map.get(c)]);
            ways = modmul(ways, modmulinv(factR));
            ans = modmul(ans, ways);

        }
        return ans;
    }

    int modmul(int a, int b) {
        return (int) ((a * 1L * b) % MOD);
    }

    int binExpo(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res = modmul(res, a);
            a = modmul(a, a);
            b >>= 1;
        }
        return res;
    }

    int modmulinv(int a) {
        return binExpo(a, MOD - 2);
    }

    public void fact() {
        fact[0] = 1;
        for (int i = 1; i <= 100001; i++) {
            fact[i] = modmul(fact[i - 1], i);
        }
    }

}