import java.util.*;

public class Solution2 {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(nums[0], 1);
        if (nums[0] == k)
            ans++;
        Map<Integer, Integer> curr = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            prev.put(nums[i], prev.getOrDefault(nums[i], 0) + 1);
            for (int key : prev.keySet()) {
                int gcd = gcd(key, nums[i]);
                if (gcd == k)
                    ans += prev.get(key);
                curr.put(gcd, curr.getOrDefault(gcd, 0) + prev.get(key));
            }
            prev = curr;
            curr = new HashMap<>();
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
