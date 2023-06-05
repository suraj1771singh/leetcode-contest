
import java.util.*;

class Solution {
    int cnt[];
    List<List<Integer>> adj;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        cnt = new int[n];
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int trip[] : trips) {
            f(trip[0], trip[1], new boolean[n], adj);
        }
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += price[i] * cnt[i];
        }
        System.out.println(Arrays.toString(cnt));

        int max = Math.max(solve(0, 1, new boolean[n], price, cnt), solve(0, 0, new boolean[n], price, cnt));
        System.out.println(cost + " " + max);
        return max;

    }

    int solve(int node, int canHalve, boolean seen[], int price[], int cnt[]) {
       seen[child]=true;
       for(int child: )
    }

    boolean f(int node, int target, boolean[] seen, List<List<Integer>> adj) {
        if (node == target) {
            for (int i = 0; i < seen.length; i++) {
                if (seen[i]) {
                    cnt[i]++;
                }
            }
            cnt[target]++;
            return true;
        }
        seen[node] = true;
        for (int child : adj.get(node)) {
            if (!seen[child]) {
                if (f(child, target, seen, adj))
                    return true;
            }
        }
        seen[node] = false;
        return false;

    }
}