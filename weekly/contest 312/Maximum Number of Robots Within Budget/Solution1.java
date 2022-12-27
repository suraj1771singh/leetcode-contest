import java.util.ArrayDeque;
import java.util.Deque;

//SLIDING WINDOW 
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length, max_len = 0;

        // prefix sum array
        long prefixSum[] = new long[n];
        prefixSum[0] = runningCosts[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + runningCosts[i];

        Deque<Integer> q = new ArrayDeque<>();
        int s = -1, e = 0;
        for (; e < n; e++) {
            // creating monotonic queue
            while (!q.isEmpty() && chargeTimes[q.getLast()] <= chargeTimes[e]) {
                q.removeLast();
            }
            q.add(e);
            int len = e - s;
            int max = chargeTimes[q.peekFirst()];
            long cost = (s == -1) ? max + len * prefixSum[e] : max + len * (prefixSum[e] - prefixSum[s]);
            if (cost <= budget)
                max_len = Math.max(max_len, len);
            while (!q.isEmpty() && s <= e && cost > budget) {
                s++;
                len = e - s;
                if (q.peekFirst() == s)
                    q.removeFirst();

                max = q.isEmpty() ? 0 : chargeTimes[q.peekFirst()];
                cost = max + len * (prefixSum[e] - prefixSum[s]);
            }
            max_len = Math.max(max_len, len);
        }
        return max_len;

    }
}
// Time complexity : O(n);
// Space complexity : O(n)