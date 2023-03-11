
import java.util.*;

//--------MEMOIZATION

class Solution {
    private static final int MOD = 1000000007;

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int dp[][][] = new int[n][51][1001];
        for (int x[][] : dp)
            for (int y[] : x)
                Arrays.fill(y, -1);
        return f(n - 1, types[n - 1][0], target, types, dp);

    }

    public int f(int ind, int ways, int target, int a[][], int dp[][][]) {
        if (target == 0)
            return 1;
        if (target < 0 || ind < 0)
            return 0;

        if (dp[ind][ways][target] != -1)
            return dp[ind][ways][target];
        if (ways > 0) {
            return dp[ind][ways][target] = (f(ind, ways - 1, target - a[ind][1], a, dp)
                    + f(ind - 1, a[Math.max(ind - 1, 0)][0], target, a, dp))
                    % MOD;
        } else
            return dp[ind][ways][target] = f(ind - 1, a[Math.max(ind - 1, 0)][0], target, a, dp);
    }

}