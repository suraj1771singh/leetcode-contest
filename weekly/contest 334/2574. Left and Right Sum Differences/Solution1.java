class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int pre[]= new int[n];
        int post[]= new int[n];
        pre[0]=nums[0];
        post[n-1]=nums[n-1];
        for(int i=1; i<n; i++){
            pre[i]=pre[i-1]+nums[i];
        }
        for(int i=n-2; i>=0; i--){
            post[i]=post[i+1]+nums[i];
        }
        int ans[]= new int[n];
        for(int i=0; i<n; i++){
            ans[i]=Math.abs(post[i]-pre[i]);
        }
        return ans;
    }
}