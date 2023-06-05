import java.util.*;

//--------------------MEMOIZATION
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String st : dictionary)
            set.add(st);
        Integer dp[] = new Integer[s.length()];
        return f(0, s.length(), s, set, dp);
    }

    int f(int ind, int n, String s, Set<String> dict, Integer dp[]) {
        if (ind >= n)
            return 0;
        if (dp[ind] != null)
            return dp[ind];
        int extra = n;
        StringBuilder check = new StringBuilder();
        for (int i = ind; i < n; i++) {
            check.append(s.charAt(i));
            if (dict.contains(check.toString()))
                extra = Math.min(extra, f(i + 1, n, s, dict, dp));
            else
                extra = Math.min(extra, check.length() + f(i + 1, n, s, dict, dp));
        }
        return dp[ind] = extra;
    }
}
// Time complexity : O(n^2)