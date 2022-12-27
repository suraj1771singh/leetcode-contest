
import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// NOTE : BSt might not be balanced, so first convert it into an sorted array
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, list);
        // using binary seach to get lower and upper bound

        for (int i = 0; i < queries.size(); i++) {
            int maxi = -1, mini = -1;
            int l = 0, h = list.size() - 1;
            while (l <= h) {
                int mid = (l + h) / 2;

                if (list.get(mid) > queries.get(i)) {
                    maxi = list.get(mid);
                    h = mid - 1;
                } else if (list.get(mid) < queries.get(i)) {
                    mini = list.get(mid);
                    l = mid + 1;
                } else {
                    mini = maxi = list.get(mid);
                    break;
                }
            }
            ans.add(new ArrayList<>(Arrays.asList(mini, maxi)));
        }

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
// Time complexity : O(n*logm) , m is the number of nodes in a tree
// Space complexity : O(m)