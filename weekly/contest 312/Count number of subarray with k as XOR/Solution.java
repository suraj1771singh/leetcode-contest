import java.util.*;

//Problem link
//https://www.codingninjas.com/codestudio/problems/count-subarrays-with-given-xor_1115652

class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int xorr = 0;
        for (int i = 0; i < arr.size(); i++) {
            xorr = xorr ^ arr.get(i);
            if (xorr == k)
                cnt++;
            if (map.containsKey(xorr ^ k))
                cnt += map.get(xorr ^ k);
            map.put(xorr, map.getOrDefault(xorr, 0) + 1);
        }
        return cnt;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)