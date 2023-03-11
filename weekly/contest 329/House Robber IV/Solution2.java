import java.util.Stack;

class Solution {
    Stack<Integer> st;
    int ans;

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        ans = Integer.MAX_VALUE;
        st = new Stack<>();
        f(n - 1, k, nums);
        return ans;
    }

    void f(int ind, int k, int nums[]) {

        if (st.size() == k) {
            int maxi = 0;
            for (int i : st) {
                maxi = Math.max(maxi, i);
                ans = Math.min(maxi, ans);
            }
        }

        if (ind < 0)
            return;
        f(ind - 1, k, nums);
        st.push(nums[ind]);
        f(ind - 1, k, nums);
        st.pop();

    }
}