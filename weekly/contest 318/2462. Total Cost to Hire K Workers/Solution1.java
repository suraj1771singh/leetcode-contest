import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        boolean isTaken[] = new boolean[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]);

        int left, right;
        for (int i = 0; i < candidates; i++) {
            if (!isTaken[i]) {
                pq.add(i);
                isTaken[i] = true;
            }
        }
        left = candidates;
        for (int i = n - 1; i >= n - candidates; i--) {
            if (!isTaken[i]) {
                pq.add(i);
                isTaken[i] = true;
            }
        }
        right = n - candidates - 1;
        long ans = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int ind = pq.poll();
            ans += costs[ind];// cost
            if (ind < left) {
                // left se nikala hai
                if (left < n && !isTaken[left]) {
                    pq.add(left);
                    isTaken[left] = true;
                    left++;
                }
            } else {
                // right se nikala hai
                if (right >= 0 && !isTaken[right]) {
                    pq.add(right);
                    isTaken[right] = true;
                    right--;
                }
            }

        }
        return ans;
    }
}