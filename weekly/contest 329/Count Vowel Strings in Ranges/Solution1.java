import java.util.HashSet;
import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = words.length;
        int presum[] = new int[n];
        String s = words[0];
        int len = s.length();
        if (set.contains(s.charAt(0)) && set.contains(s.charAt(len - 1)))
            presum[0] = 1;

        for (int i = 1; i < n; i++) {
            s = words[i];
            len = s.length();
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(len - 1)))
                presum[i] = presum[i - 1] + 1;
            else
                presum[i] = presum[i - 1];
        }

        int res[] = new int[queries.length];
        int ind = 0;
        for (int query[] : queries) {
            if (query[0] - 1 < 0)
                res[ind++] = presum[query[1]];
            else
                res[ind++] = presum[query[1]] - presum[query[0] - 1];
        }
        return res;
    }
}