import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0, cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : banned)
            set.add(i);
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (sum + i <= maxSum) {
                    cnt++;
                    sum += i;
                }
            }
        }
        return cnt;
    }
}