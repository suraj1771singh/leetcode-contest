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

class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int q = 0; q < n; q++) {
            int maxi = -1, mini = -1;
            TreeNode r = root;
            while (r != null) {
                if (r.val < queries.get(q)) {
                    mini = r.val;
                    r = r.right;
                } else if (r.val > queries.get(q)) {
                    maxi = r.val;
                    r = r.left;
                } else {
                    mini = maxi = r.val;
                    break;
                }
            }
            ans.add(new ArrayList<>(Arrays.asList(mini, maxi)));
        }
        return ans;
    }
}
// assuming tree is balance , TC : O(n*log m) , m is the no. of nodes
// giving TLE