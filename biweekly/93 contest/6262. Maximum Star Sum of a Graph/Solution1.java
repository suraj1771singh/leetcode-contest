import java.util.*;

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = vals.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, vals[i]);
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> temp = adj.get(i);
            Collections.sort(temp, (a, b) -> vals[b] - vals[a]);
            int sum = vals[i];
            for (int j = 0; j < Math.min(temp.size(), k); j++) {
                ans = Math.max(ans, sum);
                sum += vals[temp.get(j)];
            }
            ans = Math.max(ans, sum);

        }
        return ans;

    }
}
// Time complexity : O(n^2)