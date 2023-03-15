import java.util.*;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l = 0, ans = 0, n = nums.length;
        for (int i = n - n / 2; i < n; i++) {
            if (2 * nums[l] <= nums[i]) {
                l++;
                ans += 2;
            }
        }
        return ans;
    }
}
// Time complexity : O(n*logn)
// One more way using Binary search ,but gettng TLE for last case ig