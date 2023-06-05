import java.util.*;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            s1.push(nums[i]);
        }
        for (int i = n / 2; i < n; i++) {
            s2.push(nums[i]);
        }
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = 0;
            if (s1.size() >= s2.size()) {
                a = s1.pop();
            } else {
                a = s2.pop();
            }

            if (!s1.isEmpty() && !s2.isEmpty()) {
                if (a - s1.peek() < s2.peek() - a) {
                    pq.add(a - s1.pop());
                } else {
                    pq.add(s2.peek() - a);
                }

            } else if (s1.isEmpty() && !s2.isEmpty()) {
                pq.add(s2.peek() - a);

            } else if (s2.isEmpty() && !s1.isEmpty()) {
                pq.add(a - s1.peek());
            }

        }
        int max = -(int) 1e9;
        while (p-- > 0) {
            max = Math.max(max, pq.poll());
        }
        return max;
    }
}