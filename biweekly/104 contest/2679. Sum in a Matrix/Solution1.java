class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < m; i++) {
            int max = nums[0][i];
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}