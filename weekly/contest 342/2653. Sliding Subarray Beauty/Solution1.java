import java.util.TreeSet;

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] - nums[b]);
        for (int i = 0; i < k; i++) {
            set.add(i);
            if (set.size() > x)
                set.pollLast();
        }
        ans[0] = nums[set.last()] > 0 ? 0 : nums[set.last()];
        int ind = 1;
        for (int i = k; i < n; i++) {
            set.remove(i - k);
            set.add(i);
            if (set.size() > x)
                set.pollLast();
            ans[ind++] = nums[set.last()] > 0 ? 0 : nums[set.last()];

        }
        return ans;
    }
}