//---------------BIT MANIPULATION

class Solution1 {

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int bitmap[][] = new int[n][31];

        // preprocessing suffix OR array
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < 31; k++) {
                if ((nums[i] & (1 << k)) != 0)
                    bitmap[i][k] = (i + 1 >= n) ? 1 : bitmap[i + 1][k] + 1;
                else
                    bitmap[i][k] = (i + 1 >= n) ? 0 : bitmap[i + 1][k];
            }
        }
        int ans[] = new int[n];

        // main logic
        for (int i = 0; i < n; i++) {
            int len = 1, or = nums[i], j = i + 1;
            while (j < n && canMoveFwd(bitmap, or, j)) {
                or = or | nums[j++];
                len++;
            }
            ans[i] = len;
        }
        return ans;

    }

    private boolean canMoveFwd(int[][] bitmap, int or, int ind) {
        for (int k = 0; k < 31; k++) {
            if ((or & (1 << k)) == 0 && bitmap[ind][k] > 0)
                return true;
        }
        return false;
    }
}
// Time complexity : O(n*n*k)