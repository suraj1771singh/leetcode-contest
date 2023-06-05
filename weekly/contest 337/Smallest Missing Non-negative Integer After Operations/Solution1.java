class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int l = 0, h = (int) 1e9;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] % value + value) % value;

        }
        int ans = 0;
        while (l <= h) {

            int mid = l + (h - l) / 2;
            // find is valid or not
            if (isValid(mid, nums)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;

        }
        return ans;
    }

    public boolean isValid(int a, int[] nums) {
        for (int i : nums) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}