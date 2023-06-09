import java.util.*;

class Solution {
    final int MOD = (int) 1e9 + 7;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    sum = (sum + pow(nums[j], 3)) % MOD;
                } else {
                    int cnt = j - i - 1;
                    sum = (sum + mul(mul(pow(2, cnt), pow(nums[j], 2)), nums[i])) % MOD;
                }
            }
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