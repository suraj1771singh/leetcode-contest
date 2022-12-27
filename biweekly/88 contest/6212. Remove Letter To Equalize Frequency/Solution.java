import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.*;

class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int key = c - 'a';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // --------- edge case
        int cnt = 0;
        for (int i : map.values()) {
            if (i == 1)
                cnt++;

        }
        if (cnt == map.size())
            return true;
        // -----------------

        boolean flag = false;
        while (!flag) {
            for (int i : map.keySet()) {
                if (map.get(i) == 1)
                    flag = true;
                map.put(i, map.get(i) - 1);

            }
        }
        int cnt_one = 0, cnt_zero = 0, cnt_other = 0;
        for (int i : map.values()) {
            if (i == 1)
                cnt_one++;
            else if (i == 0)
                cnt_zero++;
            else
                cnt_other++;
        }
        if ((cnt_one == 1 || cnt_zero == 1) && (cnt_other == 0))
            return true;
        else
            return false;

    }
}