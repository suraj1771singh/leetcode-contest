class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean seen[][] = new boolean[grid.length][grid[0].length];
            ans[i] = dfs(0, 0, grid, queries[i], seen);
        }
        return ans;

    }

    public int dfs(int i, int j, int[][] grid, int limit, boolean seen[][]) {
        seen[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 1;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < m && !seen[x][y] && grid[x][y] < limit) {
                cnt += dfs(x, y, grid, limit, seen);
            }
        }
        return cnt;

    }
}