class Solution {
    int parent[];
    int size[];
    int degree[];

    public int countCompleteComponents(int n, int[][] edges) {
        int m = edges.length, ans = 0;
        parent = new int[n];
        size = new int[n];
        degree = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            union(u, v);
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                boolean f1 = true;
                for (int j = 0; j < n; j++) {
                    if (parent[j] == i && degree[j] != size[i] - 1) {
                        f1 = false;
                        break;
                    }
                }
                if (f1)
                    ans++;
            }
        }
        return ans;
    }

    int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);
        if (p1 == p2)
            return;
        if (size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
        } else {
            parent[p1] = p2;
            size[p2] += size[p1];
        }
    }
}
// Time complexity : O(n^2)