
// This method is known as TRINARY search,

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int l=0, h=Integer.MAX_VALUE;
        for(int i : nums){
            h=Math.max(h,i);
            l=Math.min(l,i);
        }
        long ans=getCost(1,nums,cost);

        while(l<=h){
            int mid=l+(h-l)/2;
            long p1=getCost(mid,nums,cost);
            long p2= getCost(mid+1, nums, cost);
            ans=Math.min(p1,p2);

            if(p1<p2) h=mid-1;
            else      l=mid+1;
        }
        return ans;
    }
    public long getCost(int x, int[] nums,int [] cost){
        long res=0;
        for(int i=0; i<nums.length; i++)
            res+= cost[i]*1L*Math.abs(x-nums[i]);
        return res;
    }
}
// TIme complexity : O(nlog(a))
