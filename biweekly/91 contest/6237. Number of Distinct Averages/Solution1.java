import java.util.*;

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        int l = 0, r = nums.length - 1;
        while (l < r) {
            double avg = (nums[l] + nums[r]) / 2.0;
            set.add(avg);
            l++;
            r--;
        }
        return set.size();
    }
}