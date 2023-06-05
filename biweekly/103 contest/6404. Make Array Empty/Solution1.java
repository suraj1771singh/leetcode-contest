
import java.util.*;

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Deque<Integer> q = new ArrayDeque<>();
        int mini = (int) 1e9;
        int n = nums.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            q.add(nums[i]);
            // mini = Math.min(mini, nums[i]);
            temp[i] = nums[i];
        }
        int min_ind = 0;
        Arrays.sort(temp);
        mini = temp[min_ind++];
        long cnt = 0;
        while (!q.isEmpty()) {
            if (q.peekFirst() == mini) {
                q.pollFirst();
                if (min_ind < n)
                    mini = temp[min_ind++];
            } else
                q.addLast(q.pollFirst());
            cnt++;
        }
        return cnt;

    }
}