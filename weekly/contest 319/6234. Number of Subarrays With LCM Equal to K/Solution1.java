class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currlcm = nums[i];
            if (currlcm == k)
                ans++;
            for (int j = i + 1; j < nums.length; j++) {
                currlcm = lcm(currlcm, nums[j]);
                if (currlcm == k)
                    ans++;
            }
        }
        return ans;

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
