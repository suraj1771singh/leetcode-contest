import java.util.*;
/*
IDEA: find the maximum ind position of prime factor, if mx>curr_pos, we can't
        split array at curr_pos, becoz then common fact would be >pf, whoes pos
        is mx, if mx==curr_pos, then only we can split array into two halves
        such that common factor would be 1
*/

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> pos = new HashMap<Integer, Integer>();
        HashSet<Integer> pf[] = new HashSet[n];
        for (int i = 0; i < n; i++)
            pf[i] = new HashSet<>();

        // TC : O(n*log(max(nums)))
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int p = 2; p * p <= a; p++) {
                while (a % p == 0) {
                    pf[i].add(p);
                    pos.put(p, i);
                    a /= p;
                }
            }
            if (a > 1) {
                pf[i].add(a);
                pos.put(a, i);
            }
        }
        // TC : O(n*log(max(nums)))
        int mx = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int p : pf[i])
                mx = Math.max(mx, pos.get(p));
            if (mx == i)
                return i;
        }
        return -1;
    }
}
// Time complexity : O(n*log(max(nums)))