
//----------------EFFICIENT SOLUTION (Bitwise manipulation)

public class Solution2 {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int bitmap[] = new int[31];

        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean flag = false;
            for (int k = 0; k < 31; k++) {
                if ((num & (1 << k)) != 0)
                    bitmap[k]++;
                if (bitmap[k] > 1)
                    flag = true;
            }
            if (!flag) {
                ans = Math.max(ans, i - l + 1);

            } else {
                while (l <= i) {
                    num = nums[l++];
                    for (int k = 0; k < 31; k++) {
                        if ((num & (1 << k)) != 0)
                            bitmap[k]--;
                        if (bitmap[k] > 1)
                            flag = false;
                    }

                    if (flag)
                        break;
                }
            }
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)
