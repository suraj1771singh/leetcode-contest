import java.util.*;

// Definition for a binary tree node.
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            int ind = 0;
            int temp[] = new int[q.size()];
            for (TreeNode node : q) {
                temp[ind++] = node.val;
            }
            ans += minSwaps(temp);
        }
        return ans;
    }

    public int minSwaps(int nums[]) {
        int n = nums.length, ans = 0;
        int copy[] = Arrays.copyOf(nums, n);
        HashMap<Integer, Integer> map = new HashMap<>();

        // maping number with its original index
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);

        // sorting copied array;
        Arrays.sort(copy);

        // swaping each element to its correct index using sorted copy array
        for (int i = 0; i < n; i++) {
            if (nums[i] != copy[i]) {
                int ind = map.get(copy[i]);
                map.put(nums[i], ind);
                swap(ind, i, nums);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}