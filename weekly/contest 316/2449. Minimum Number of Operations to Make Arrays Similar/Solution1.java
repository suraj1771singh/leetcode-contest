import java.util.*;

//HINT : https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/solutions/2734189/c-python-sort-odds-and-evens/?orderBy=most_votes

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        List<Integer> listEvenNums = new ArrayList<>();
        List<Integer> listOddNums = new ArrayList<>();
        List<Integer> listEvenTarget = new ArrayList<>();
        List<Integer> listOddTarget = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) listEvenNums.add(nums[i]);
            else listOddNums.add(nums[i]);

            if (target[i] % 2 == 0) listEvenTarget.add(target[i]);
            else listOddTarget.add(target[i]);
        }

        long res = 0L;
        for (int i = 0; i < listEvenNums.size(); i++) {
            int x = listEvenNums.get(i) - listEvenTarget.get(i);
            if (x > 0) res += x >> 1;
        }
        for (int i = 0; i < listOddNums.size(); i++) {
            int x = listOddNums.get(i) - listOddTarget.get(i);
            if (x > 0) res += x >> 1;
        }
        return res;
    }
}
//Time complexity : O(nlogn)