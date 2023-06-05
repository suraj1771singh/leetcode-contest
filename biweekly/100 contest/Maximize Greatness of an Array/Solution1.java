import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (j < n && nums[j] < nums[i]) {
                cnt++;
                j++;
            }
        }
        return cnt;
    }
}