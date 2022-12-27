import java.util.*;

class Solution {
    int ans;

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : roads) {
            adj.get(edge[0] - 1).add(new int[] { edge[1] - 1, edge[2] });
            adj.get(edge[1] - 1).add(new int[] { edge[0] - 1, edge[2] });
        }
        boolean vis[] = new boolean[n];
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        if (dfs(0, adj, vis, dp))
            return ans;
        else
            return -1;
    }

    private boolean dfs(int i, List<List<int[]>> adj, boolean[] vis, int dp[]) {
        boolean flag = false;
        if (i == vis.length - 1)
            flag = true;
        if (dp[i] != -1) {
            if (dp[i] == 1)
                return true;
            else
                return false;
        }
        vis[i] = true;

        for (int nei[] : adj.get(i)) {
            int u = nei[0];
            int wei = nei[1];

            if (!vis[u]) {
                ans = Math.min(ans, wei);
                flag |= dfs(u, adj, vis, dp);
            }
        }

        vis[i] = false;
        dp[i] = flag ? 1 : 0;
        return flag;
    }
}