import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        int n = basket1.length;
        for (int i = 0; i < n; i++) {
            if (basket1[i] != basket2[i]) {
                String str = basket1[i] + "-" + basket2[i];
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        long ans = 0;
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val % 2 != 0)
                return -1;
            else {
                String str[] = key.split("-");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                ans += Math.min(a, b) * (val / 2);
            }
        }
        return ans;
    }
}