
class Solution {
    public int longestSubarray(int[] nums) {
        int maxi_len = 1;
        int max_num = nums[0];
        // first find max num
        for (int i : nums)
            max_num = Math.max(max_num, i);

        int len = 0;
        for (int i : nums) {
            if (i == max_num)
                len++;
            else
                len = 0;
            maxi_len = Math.max(maxi_len, len);
        }
        return maxi_len;

    }
}