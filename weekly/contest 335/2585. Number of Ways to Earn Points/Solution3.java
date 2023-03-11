
//-----------TABULATION

class Solution {
    private static final int MOD = 1000000007;

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int dp[][][] = new int[n][51][1001];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < types[i][0]; j++) {
                for (int k = 0; k <= 1000; k++) {
                    if (k - types[i][1] >= 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i][j - 1][k - types[i][1]]) % MOD;
                    } else
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][types[Math.max(i - 1, 0)][0]][k]) % MOD;

                }
            }
        }
        return dp[n - 1][types[n - 1][0] - 1][1000];
    }
}