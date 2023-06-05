import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int f[] = new int[201];
        for (int i : nums)
            f[i]++;
        List<List<Integer>> res = new ArrayList<>();
        while (true) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < 201; i++) {

                if (f[i]-- > 0) {
                    a.add(i);
                }
            }
            if (a.size() == 0)
                break;
            res.add(a);
        }
        return res;

    }
}