import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            pq.add(sum);
        }
        if (k > pq.size())
            return -1;
        long ans = -1;
        while (k-- > 0) {
            ans = pq.poll();
        }
        return ans;

    }
}
// Time complexity : O(n*logn)