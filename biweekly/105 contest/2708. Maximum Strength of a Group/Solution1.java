import java.util.Arrays;

//ALGO : find max product from negative number and max product from positive number sperately and handel edge cases with 0
class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        long maxFromNeg = -(int) 1e9, maxFromPos = 1, prod = 1;
        boolean f1 = false, f2 = false;
        
        for (int i : nums) {
            if (i < 0) {
                prod *= i;
                maxFromNeg = Math.max(maxFromNeg, prod);
                f1 = true;
            } else {
                maxFromPos = Math.max(i, maxFromPos * i);
                f2 = true;
            }
        }
        if (!f1) return maxFromPos;
        else if (!f2) return maxFromNeg;
        else if (maxFromPos == 0) return Math.max(maxFromPos, maxFromNeg);
        else return Math.max(maxFromPos, maxFromPos * maxFromNeg);

    }
}
// Time complexity : O(n*logn)