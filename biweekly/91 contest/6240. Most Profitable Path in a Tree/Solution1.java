import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        int[] seen = new int[n];
        int ans = Integer.MIN_VALUE;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i : adj.get(0)) {
            for (int j : adj.get(bob)) {
                ans = Math.max(ans, f(i, j, seen, adj, amount));
            }
        }
        return ans;
    }

    public int f(int a_node, int b_node, int[] seen, List<List<Integer>> adj, int[] amount) {
        int ans = Integer.MIN_VALUE, cost = 0;
        if (a_node == b_node)
            cost = amount[a_node] / 2;
        else if (seen[a_node] == 2)
            cost = 0;
        else
            cost = amount[a_node];

        seen[a_node] = 1;
        seen[b_node] = 2;

        for (int i : adj.get(a_node)) {
            if (b_node != 0) {
                for (int j : adj.get(b_node)) {
                    if (seen[i] != 1 && seen[j] != 2)
                        ans = Math.max(ans, f(i, j, seen, adj, amount));
                }
            } else
                ans = Math.max(ans, f(i, b_node, seen, adj, amount));
        }
        if (ans == Integer.MIN_VALUE)
            return cost;
        return cost + ans;
    }

}