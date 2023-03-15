
import java.util.*;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        if (nums.length <= 0)
            return 0;
        int n = nums.length;
        Arrays.sort(nums);
        boolean marked[] = new boolean[n];
        for (int i = n - n / 2; i < n; i++) {
            if (marked[i])
                continue;
            int pos = getPos(nums[i], 0, i - 1, marked, nums) - 1;
            while (pos >= 0 && marked[pos])
                pos--;
            if (pos >= 0) {
                marked[i] = true;
                marked[pos] = true;
            }
        }
        int ans = 0;
        for (boolean f : marked)
            if (f)
                ans++;
        return ans;

    }

    public int getPos(int x, int l, int h, boolean[] marked, int[] a) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (2 * a[mid] == x && !marked[mid])
                return mid + 1;
            else if (2 * a[mid] < x)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h + 1;
    }
}
// Time complexity : O(n*logn)