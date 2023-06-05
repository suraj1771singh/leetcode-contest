class Solution {
    int dirs[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxi = Math.max(maxi, dfs(i, j, grid));
                }
            }
        }
        return maxi;
    }

    private int dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int sum = grid[i][j];
        grid[i][j] = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < m && grid[i][j] != 0) {
                sum += dfs(x, y, grid);
            }
        }
        return sum;
    }
}