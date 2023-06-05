import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String st : dictionary)
            set.add(st);
        return f(0, s.length(), s, set);
    }

    int f(int ind, int n, String s, Set<String> dict) {
        if (ind >= n)
            return 0;
        int extra = n;
        String check = "";
        for (int i = ind; i < n; i++) {
            check += s.charAt(i);
            if (dict.contains(check))
                extra = Math.min(extra, f(i + 1, n, s, dict));
            else
                extra = Math.min(extra, check.length() + f(i + 1, n, s, dict));
        }
        return extra;
    }
}