import java.util.*;

class Solution {
    public int splitNum(int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        String s1 = "", s2 = "";
        int n = c.length;
        for (int i = 0; i < n; i += 2) {
            s1 += c[i];
            if (i + 1 < n)
                s2 += c[i + 1];
        }
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }
}