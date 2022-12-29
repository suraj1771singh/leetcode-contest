import java.util.*;

class Solution {
    public int similarPairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            Set<Character> set = new TreeSet<>();
            for (int i = 0; i < s.length(); i++)
                set.add(s.charAt(i));
            String str = "";
            for (char i : set)
                str += i;

            if (map.containsKey(str)) {
                ans += map.get(str);
            }
            map.put(str, map.getOrDefault(str, 0) + 1);

        }
        return ans;

    }
}
// Time complexity : O(n*logn )
// Space complexity : O(n)