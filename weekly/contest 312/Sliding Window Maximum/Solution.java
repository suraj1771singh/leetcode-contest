import java.util.*;

//-------------MONOTONIC QUEUE

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length, cnt = 0;
        int res[] = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.add(i);
            // keep q element in window within k
            if (q.peekFirst() == i - k)
                q.removeFirst();
            if (i >= k - 1)
                res[cnt++] = nums[q.peekFirst()];

        }
        return res;

    }
}