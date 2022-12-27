class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                ans = Math.max(ans, getSum(grid, i, j));
            }
        }
        return ans;

    }

    private int getSum(int[][] grid, int i, int j) {
        int sum = grid[i][j] + grid[i - 1][j] + grid[i - 1][j - 1] + grid[i - 1][j + 1] + grid[i + 1][j - 1]
                + grid[i + 1][j] + grid[i + 1][j + 1];
        return sum;
    }
}