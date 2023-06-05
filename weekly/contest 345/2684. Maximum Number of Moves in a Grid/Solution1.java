class Solution {
    int n;
    int m;
    int dirs[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        Integer dp[][] = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f(i, 0, grid, dp));
        }
        return ans;
    }

    int f(int i, int j, int[][] grid, Integer dp[][]) {
        int ans = 0;
        if (dp[i][j] != null)
            return dp[i][j];
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > grid[i][j])
                ans = Math.max(ans, 1 + f(x, y, grid, dp));
        }
        return dp[i][j] = ans;

    }
}