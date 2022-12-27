import java.util.*;

class Solution {
    int ans = Integer.MAX_VALUE;

    public int maxJump(int[] stones) {
        int n = stones.length;
        boolean vis[] = new boolean[n];
        f(0, false, vis, new ArrayList<Integer>(), stones);
        return ans;

    }

    public void f(int src, boolean isBack, boolean vis[], List<Integer> list, int[] stones) {
        int n = stones.length;
        vis[src] = true;
        if (!isBack && src == n - 1) {
            f(src, true, vis, list, stones);
            return;
        }
        if (isBack == true && src == 0) {
            // find max out of list
            int maxi = 0;
            for (int i = 0; i < list.size(); i++) {
                maxi = Math.max(maxi, list.get(i));
            }
            ans = Math.min(ans, maxi);
            return;
        }
        if (!isBack) {// move forward
            for (int i = src + 1; i < n; i++) {
                if (!vis[i]) {
                    list.add(Math.abs(stones[src] - stones[i]));
                    f(i, isBack, vis, list, stones);
                    list.remove(list.size() - 1);
                    f(src, isBack, vis, list, stones);
                }
            }
        } else {// move backward
            for (int i = src - 1; i >= 0; i--) {
                if (!vis[i]) {
                    list.add(Math.abs(stones[src] - stones[i]));
                    f(i, isBack, vis, list, stones);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}