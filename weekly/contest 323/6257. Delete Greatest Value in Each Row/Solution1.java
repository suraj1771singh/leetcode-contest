import java.util.*;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            int cnt = Integer.MAX_VALUE;
            for (int j = 0; j < grid.length; j++) {
                cnt = Math.max(ans, grid[j][i]);
            }
            ans += Math.max(cnt, ans);
        }
        return ans;
    }
}