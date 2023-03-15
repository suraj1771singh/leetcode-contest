
// Hint : https://www.youtube.com/watch?v=M7CHCuhkYrI
import java.util.*;

class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int cnt = 0;
        int[] isUsed = new int[2001];
        for (int[] task : tasks) {
            for (int i = task[0]; i <= task[1]; i++) {
                if (isUsed[i] == 1)
                    task[2]--;// duration will reduce
            }
            int end = task[1];
            while (task[2] > 0) {

                if (isUsed[end] == 0) {
                    task[2]--;
                    isUsed[end] = 1;
                    cnt++;
                }
                end--;

            }
        }
        return cnt;
    }
}
// Time complexity : O(n)