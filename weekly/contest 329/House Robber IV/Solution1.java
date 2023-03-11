import java.util.Stack;

class Solution {
    Stack<Integer> st;
    int K;
    int ans = Integer.MAX_VALUE;

    public int minCapability(int[] nums, int k) {
        st = new Stack<>();
        K = k;
        int n = nums.length;
        f(n - 1, k, 0, nums);
        return ans;

    }

    void f(int ind, int k, int maxi, int[] nums) {
        // if (ind < 0 && st.size() != k) {
        // return Integer.MAX_VALUE;
        // }
        // if (k == 0) {
        // if (st.size() == K)
        // return getMax(st);
        // else
        // return -1;
        // }
        // st.push(nums[ind]);
        // st.pop();
        if (k == 0) {
            ans = Math.min(maxi, ans);
            return;
        }
        if (ind < 0) {
            return;

        }

        f(ind - 1, k - 1, Math.max(maxi, nums[ind]), nums);

        f(ind - 1, k, maxi, nums);
        // int ans = Math.min(pick, notPick);
        // return ans;
    }

    int getMax(Stack<Integer> st) {
        int max = 0;
        for (int i : st)
            max = Math.max(max, i);
        return max;
    }
}