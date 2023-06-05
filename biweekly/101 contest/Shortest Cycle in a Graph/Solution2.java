import java.util.*;

public class Solution2 {
    public static int shortestCycle(int n, int[][] edges) {
        int[][] dist = new int[n][n];

        // Initialize all entries in dist to infinity, except for diagonal entries
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Update dist for each edge
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            dist[u][v] = dist[v][u] = 1;
        }

        // Calculate shortest path between all pairs of nodes using Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int shortestCycle = Integer.MAX_VALUE;

        // Check for shortest cycle for each node
        for (int i = 0; i < n; i++) {
            for (int j : neighbors(i, edges)) {
                for (int k : neighbors(j, edges)) {
                    if (i == k) {
                        shortestCycle = Math.min(shortestCycle, dist[i][j] + dist[j][k]);
                    }
                }
            }
        }

        return shortestCycle == Integer.MAX_VALUE ? -1 : shortestCycle;
    }

    private static List<Integer> neighbors(int u, int[][] edges) {
        List<Integer> neighbors = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == u) {
                neighbors.add(edge[1]);
            } else if (edge[1] == u) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int n1 = 7;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 3 } };
        int ans1 = shortestCycle(n1, edges1);
        System.out.println("Test Case 1: " + ans1); // Expected output: 3

        int n2 = 4;
        int[][] edges2 = { { 0, 1 }, { 0, 2 } };
        int ans2 = shortestCycle(n2, edges2);
        System.out.println("Test Case 2: " + ans2); // Expected output: -1
    }

}
