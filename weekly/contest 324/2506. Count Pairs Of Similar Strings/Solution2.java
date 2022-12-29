import java.util.*;

//using bitmasking and store the mask in hashmap

class Solution2 {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - 'a' + 1;
                // set ind bit
                mask = mask | (1 << ind);
            }
            if (map.containsKey(mask))
                ans += map.get(mask);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1), mask is 32 bit only , so constant