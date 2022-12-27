import java.util.Arrays;

//HINT : https://leetcode.com/problems/number-of-great-partitions/solutions/2948009/java-c-python-knapsack-problem/?orderBy=most_votes

class Solution {
    long s;
    final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        s = 0;
        for (int i : nums)
            s += i;
        if (s < 2 * k)
            return 0;
        // find count of subarrays whoes sum is < k
        long dp[][] = new long[n][k];
        for (long r[] : dp)
            Arrays.fill(r, -1);
        long num = f(n - 1, nums, k, 0, dp);
        // ans = total subsets - 2*subset whoes sum is <k
        long pow = (long) (Math.pow(2, n) % MOD);
        long ans = ((pow - ((2 * num) % MOD)) + MOD) % MOD;
        return (int) ans;
    }

    public long f(int ind, int[] nums, int k, int sum, long dp[][]) {
        if (ind < 0) {
            if (sum < k)
                return 1;
            else
                return 0;
        }
        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        long pick = 0;
        if (sum + nums[ind] < k)
            pick = f(ind - 1, nums, k, sum + nums[ind], dp) % MOD;
        long notpick = f(ind - 1, nums, k, sum, dp) % MOD;
        dp[ind][sum] = (pick + notpick) % MOD;
        return dp[ind][sum];
    }
}
// Time complexity : O(n*k)