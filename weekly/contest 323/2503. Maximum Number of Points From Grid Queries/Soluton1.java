import java.util.*;

//---------ALGO
/*
 * use BFS and sort queries because, if num2 > num1 then score(num2) > score(num1) , 
 * so idea is to starting calculating score for num2 where num1 has left
 * (for this queue will store the points after which num1 was not satisfying the conditions)
 * and cumulatively add score smaller(ie num1) number to larger number(i.e num2) 
 */
class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int[] cpy_query = Arrays.copyOf(queries, queries.length);

        Arrays.sort(queries);

        int ans[] = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> grid[a.x][a.y] - grid[b.x][b.y]);
        boolean[][] seen = new boolean[n][m];

        pq.add(new Pair(0, 0));
        seen[0][0] = true;

        for (int i = 0; i < queries.length; i++) {
            int limit = queries[i];
            int score = 0;
            while (!pq.isEmpty()) {
                Pair pt = pq.peek();
                if (limit > grid[pt.x][pt.y]) {
                    pq.poll();
                    score++;
                } else
                    break;
                for (int dir[] : dirs) {
                    int x = dir[0] + pt.x;
                    int y = dir[1] + pt.y;
                    if (x >= 0 && x < n && y >= 0 && y < m && !seen[x][y]) {
                        pq.add(new Pair(x, y));
                        seen[x][y] = true;
                    }
                }
            }
            if (i > 0)
                map.put(limit, map.get(queries[i - 1]) + score);
            else
                map.put(limit, score);
        }

        for (int i = 0; i < queries.length; i++)
            ans[i] = map.get(cpy_query[i]);
        return ans;
    }
}

class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }

    public String toString() {
        return x + " " + y;
    }
}
// Time complexity : O(n*m log(n*m))
// Space complexity : O(n*m)