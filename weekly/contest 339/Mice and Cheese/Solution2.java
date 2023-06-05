class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int K) {
        int n = reward1.length;
        int dp[][] = new int[n][K + 1];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int k = 1; k <= K; k++) {
                int a = 0;
                int b = 0;
                if (k > 0)
                    a = reward1[ind] + dp[ind + 1][k - 1];
                b = reward2[ind] + dp[ind + 1][k];
                dp[ind][k] = Math.max(a, b);

            }
        }

        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(0, k, reward1, reward2, dp);
    }

    int f(int ind, int k, int c1[], int c2[], int dp[][]) {
        if (ind >= c1.length) {
            if (k == 0)
                return 0;
            else
                return -(int) 1e9;
        }
        if (dp[ind][k] != -1)
            return dp[ind][k];
        int a = 0;
        int b = 0;
        // if mouse 1 eat
        if (k > 0)
            a = c1[ind] + f(ind + 1, k - 1, c1, c2, dp);
        b = c2[ind] + f(ind + 1, k, c1, c2, dp);
        return dp[ind][k] = Math.max(a, b);
    }

}