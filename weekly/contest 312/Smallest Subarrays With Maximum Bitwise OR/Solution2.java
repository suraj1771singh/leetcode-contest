//NOTE : https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/discuss/2589058/simple-clean-C%2B%2B-code-oror-O(N)-solution-oror-Bit-Manipulation

public class Solution2 {
    public int[] smallestSubarrays(int[] nums) {
        // maintain nearest set bit array
        int n = nums.length;
        int nearest[] = new int[31];
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int lastbit = i;
            for (int k = 0; k < 31; k++) {
                if ((nums[i] & (1 << k)) != 0)// set bit
                    nearest[k] = i;
                lastbit = Math.max(lastbit, nearest[k]);

            }
            ans[i] = lastbit - i + 1;
        }
        return ans;
    }
}
