import java.util.List;

class Solution {
    private static final int MOD = 1000000007;

    public int waysToReachTarget(int target, int[][] types) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] a : types) {
            for (int i = target; i >= 0; i--) {
                for (int j = 1; j <= a[0] && i - j * a[1] >= 0; j++) {
                    dp[i] = (dp[i] + dp[i - j * a[1]]) % MOD;
                }
            }
        }
        return dp[target];
    }
}