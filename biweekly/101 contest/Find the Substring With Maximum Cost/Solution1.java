import java.util.HashMap;
import java.util.*;

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        for (int i = 0; i < 26; i++) {
            map.putIfAbsent((char) (i + 'a'), i + 1);
        }
        int n = s.length();
        int dp[] = new int[n];
        dp[0] = map.get(s.charAt(0));
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(s.charAt(i), dp[i - 1] + s.charAt(i));
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}