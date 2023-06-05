import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int ans = (int) 1e9;
        boolean seen[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                ans = Math.min(ans, dfs(i, new boolean[n], seen, adj));
            }
        }
        return ans == (int) 1e9 ? -1 : ans;

    }

    int dfs(int node, boolean[] stack, boolean[] seen, List<List<Integer>> adj) {
        if (stack[node])
            return 0;
        int len = (int) 1e9;
        stack[node] = true;
        seen[node] = true;
        for (int child : adj.get(node)) {
            if (seen[child])    
                continue;
            len = Math.min(len, 1 + dfs(child, stack, seen, adj));

        }
        stack[node] = false;
        return len;
    }
}