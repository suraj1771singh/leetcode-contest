import java.util.*;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int cnt = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                cnt = Math.max(cnt, grid[j][i]);
            }
            ans += cnt;
        }
        return ans;
    }
}
// Time complexity : O(n*m)