
//------ALGO
/*
 * 1. for each starting index i, we find continous streak of numbers which are divisible by k
 * 2. and if gcd of that streak is k, we increment the count
 */
class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[j] % k != 0)
                    break;
                nums[i] = gcd(nums[i], nums[j]);
                res += nums[i] == k ? 1 : 0;
            }
        }
        return res;

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
// Time complexity : O(n^2), little bit optmized than brute force