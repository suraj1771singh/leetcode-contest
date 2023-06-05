class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int ind1 = -1, ind2 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                ind1 = i;
            else if (nums[i] == n)
                ind2 = i;
        }
        int ans = ind1 + n - 1 - ind2;
        if (ind1 > ind2)
            return ans - 1;
        else
            return ans;
    }
}