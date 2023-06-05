import java.util.*;

class Solution {
    public int miceAndCheese(int[] a, int[] b, int k) {
        List<Pair<Integer, Integer>> v = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int diff = a[i] - b[i];
            v.add(new Pair<>(diff, i));
        }
        Collections.sort(v, Collections.reverseOrder());
        int cnt = 0, ans = 0;
        for (Pair<Integer, Integer> it : v) {
            if (cnt < k)
                ans += a[it.second];
            else
                ans += b[it.second];
            cnt++;
        }
        return ans;
    }
}
class Pair{
    int first;
    int second;
    Pair(int a, int b){
        first=a;
        second
    }
}