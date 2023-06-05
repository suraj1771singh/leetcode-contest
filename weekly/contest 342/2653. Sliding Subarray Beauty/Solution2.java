
//algo : keep track of freq of negative numbers

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int map[] = new int[51];
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i - k >= 0) {
                // get smallest negative number
                int y = x;
                for (int ind = 0; ind < 51; ind++) {

                    y -= map[ind];
                    if (y <= 0) {
                        ans[i - k] = ind - 50;
                        break;
                    }
                }
                if (nums[i - k] <= 0)
                    map[50 + nums[i - k]]--;
            }

            if (nums[i] <= 0)
                map[50 + nums[i]]++;
        }

        for (int ind = 0; ind < 51; ind++) {
            x -= map[ind];
            if (x <= 0) {
                ans[n - k] = ind - 50;
                break;
            }
        }
        return ans;
    }
}
