import java.util.Stack;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty())
                stack.push(nums[i]);
            else {

                Stack<Integer> temp = new Stack<>();
                while (!stack.isEmpty()) {
                    int ele = stack.pop();
                    if ((ele & nums[i]) != 0) {
                        stack.clear();
                        break;
                    } else
                        temp.push(ele);
                }
                while (!temp.isEmpty())
                    stack.push(temp.pop());

                stack.push(nums[i]);
            }
            ans = Math.max(ans, stack.size());
        }
        return ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)