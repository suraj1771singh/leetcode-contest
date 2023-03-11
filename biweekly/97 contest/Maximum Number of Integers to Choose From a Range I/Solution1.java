import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned)
            set.add(i);

    }

    int f(int num, int n, int maxSum, Set<Integer> set) {
        if (num >= n)
            return 0;
        if (set.contains(num)) {
            return f(num + 1, n, maxSum, set);
        }

        int pick = num + f(num + 1, n, maxSum, set);
        int notpick = f(num + 1, n, maxSum, set);
        return pick + notpick;
    }

}