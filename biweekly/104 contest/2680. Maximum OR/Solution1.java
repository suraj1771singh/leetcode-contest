class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long suffixOR[] = new long[n];
        long cal = 0;
        // calculate from right side
        for (int i = n - 1; i >= 0; i--) {
            suffixOR[i] = cal;
            cal = cal | nums[i];
        }
        cal = 0;
        long ans = 0;
        // calculate from left side
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, cal | (long) nums[i] << k | suffixOR[i]);
            cal = cal | nums[i];
        }
        return ans;
    }
}
// Time complexity : O(n)