import java.util.Arrays;

class Solution {
    final int mod = (int) Math.pow(10, 9) + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];
        Arrays.fill(dp, -1);
        return f(low, high, zero, one, 0, dp) % mod;
    }

    public int f(int low, int high, int a, int b, int len, int[] dp) {
        if (len > high)
            return 0;
        if (dp[len] != -1)
            return dp[len];
        if (len >= low && len <= high) {
            int ch1 = f(low, high, a, b, len + a, dp);
            int ch2 = f(low, high, a, b, len + b, dp);
            return dp[len] = (1 + ch1 + ch2) % mod;
        }
        if (len < low) {
            int ch1 = f(low, high, a, b, len + a, dp);
            int ch2 = f(low, high, a, b, len + b, dp);
            return dp[len] = (ch1 + ch2) % mod;
        }
        return 0;
    }
}