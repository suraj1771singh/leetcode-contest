import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        long ans[] = new long[nums.length];
        Map<Integer, long[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                long a[] = map.get(nums[i]);
                ans[i] += i * a[0] - a[1];
                a[0]++;
                a[1] += i;
            } else {
                long a[] = new long[2];
                a[0]++;
                a[1] = i;
                map.put(nums[i], a);
            }

        }
        map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                long a[] = map.get(nums[i]);
                ans[i] += i * a[0] - a[1];
                a[0]++;
                a[1] += i;
            } else {
                long a[] = new long[2];
                a[0]++;
                a[1] = i;
                map.put(nums[i], a);
            }
        }
        return ans;

    }
}