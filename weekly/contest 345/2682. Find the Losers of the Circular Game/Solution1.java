import java.util.*;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean seen[] = new boolean[n];
        int ind = 0;
        int cnt = 1;
        while (!seen[ind]) {
            seen[ind] = true;

            ind = (ind + cnt * k) % n;
            cnt++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seen[i] == false)
                list.add(i + 1);
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}