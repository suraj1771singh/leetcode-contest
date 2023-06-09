import java.util.*;;

class Solution {
    final int MOD = (int) 1e9 + 7;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        long prefix = 0;
        for (int j = 0; j < n; j++) {
            sum = ((sum + pow(nums[j], 3)) % MOD + mul(pow(nums[j], 2), (int) prefix)) % MOD;
            prefix = (2 * prefix) % MOD;
            prefix = (prefix + nums[j]) % MOD;

        }
        return (int) sum;
    }

    int pow(int num, int n) {
        long ans = 1;
        while (n-- > 0) {
            ans = (ans * num) % MOD;
        }
        return (int) ans;
    }

    int mul(int a, int b) {
        return (int) ((a * 1L * b) % MOD);
    }
}
