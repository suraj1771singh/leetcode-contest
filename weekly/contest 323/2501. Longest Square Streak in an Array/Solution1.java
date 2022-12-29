import java.util.HashSet;
import java.util.*;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i : nums)
            set.add(i);
        int ans = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                int len = 1;
                int ele = i;
                set.remove(ele);
                while (set.contains(ele * ele)) {
                    len++;
                    set.remove(ele * ele);
                    ele = ele * ele;
                }
                ans = Math.max(ans, len);

            }
        }
        return ans==1 ? -1 : ans;
    }
}