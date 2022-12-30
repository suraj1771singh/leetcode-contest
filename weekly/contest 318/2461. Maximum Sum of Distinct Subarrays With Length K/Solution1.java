import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (set.contains(nums[i])) {
                int item = q.pollFirst();
                set.remove(item);
                sum -= item;
            }
            set.add(nums[i]);
            q.addLast(nums[i]);
            sum += nums[i];
            if (q.size() > k) {
                int item = q.pollFirst();
                set.remove(item);
                sum -= item;
            }
            if (q.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}