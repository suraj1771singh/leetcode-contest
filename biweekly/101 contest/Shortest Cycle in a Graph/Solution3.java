import java.util.ArrayList;
import java.util.*;

class Solution {

    final int N = 100200;

    List<List<Integer>> adj = new ArrayList<>();

    public int findShortestCycle(int n, int[][] edges) {

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            int[] minDis = new int[n];
            Arrays.fill(minDis, (int) 1e9);

            int[] par = new int[n];
            Arrays.fill(par, -1);

            minDis[i] = 0;
            Queue<Integer> q = new LinkedList<>();

            q.add(i);

            while (!q.isEmpty()) {
                int x = q.poll();

                for (int child : adj.get(x)) {
                    if (minDis[child] == (int) (1e9)) {

                        minDis[child] = 1 + minDis[x];

                        par[child] = x;

                        q.add(child);
                    } else if (par[x] != child && par[child] != x)
                        ans = Math.min(ans, minDis[x] + minDis[child] + 1);
                }
            }
        }

        if (ans == Integer.MAX_VALUE)
            return -1;

        else
            return ans;
    }

}