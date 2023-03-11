
import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        return f(n - 1, types[n - 1][0], target, types);

    }

    public int f(int ind, int ways, int target, int a[][]) {
        if (target == 0)
            return 1;
        if (ind < 0)
            return 0;
        if (ways > 0) {
            return (f(ind, ways - 1, target - a[ind][1], a) + f(ind - 1, a[Math.max(ind - 1, 0)][0], target, a)) % MOD;
        } else
            return f(ind - 1, a[Math.max(ind - 1, 0)][0], target, a);
    }

}