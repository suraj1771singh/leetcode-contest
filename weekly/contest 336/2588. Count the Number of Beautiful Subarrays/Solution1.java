import java.util.*;

class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        long res = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            if (map.containsKey(xor))
                res += map.get(xor);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return res;
    }
}
// Time complexity : O(n)