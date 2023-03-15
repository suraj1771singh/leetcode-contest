import java.util.*;

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int ans=0;
        long sum=0;
        int pos=-1;
        for(int i=0; i<n; i++){
            if(nums[i]>0){
                if(pos==-1) pos=i;
                sum+=nums[i];
                if(sum>0) ans++;
            }
        }
        for(int i=pos-1; i>=0; i--){
            sum+=nums[i];
            if(sum>0) ans++;
        }
        return ans;
    }
}