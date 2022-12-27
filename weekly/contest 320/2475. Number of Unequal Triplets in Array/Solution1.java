class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length,cnt=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(nums[i]==nums[j]) continue;
                for(int k=j; k<n ; k++){
                    if(nums[i]==nums[k] || nums[j]==nums[k]) continue;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}