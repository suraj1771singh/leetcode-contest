import java.util.*;

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

class TreeNodePair {
    public TreeNode first;
    public TreeNode second;

    public TreeNodePair(TreeNode first, TreeNode second) {
        this.first = first;
        this.second = second;
    }

    public TreeNode getFirst() {
        return first;
    }

    public TreeNode getSecond() {
        return second;
    }

}

class Solution {
    TreeNode replaceValueInTree(TreeNode root) {
        Map<TreeNode, Integer> mp = new HashMap<>();
        Queue<TreeNodePair> q = new LinkedList<>();
        List<Integer> levelSum = new ArrayList<>();
        q.offer(new TreeNodePair(root, null));
        q.offer(new TreeNodePair(null, null));
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNodePair pair = q.poll();
            TreeNode value = pair.getFirst();
            TreeNode parent = pair.getSecond();
            if (value == null) {
                levelSum.add(sum);
                if (!q.isEmpty()) {
                    q.offer(new TreeNodePair(null, null));
                    sum = 0;
                }
            } else {
                if (parent != null) {
                    int val = value.val;
                    mp.put(parent, mp.getOrDefault(parent, 0) + val);
                    sum += val;
                }
                if (value.left != null) {
                    q.offer(new TreeNodePair(value.left, value));
                }
                if (value.right != null) {
                    q.offer(new TreeNodePair(value.right, value));
                }
            }
        }
        q.offer(new TreeNodePair(root, null));
        q.offer(new TreeNodePair(null, null));
        int level = 0;
        while (!q.isEmpty()) {
            TreeNodePair pair = q.poll();
            TreeNode value = pair.getFirst();
            TreeNode parent = pair.getSecond();
            if (value == null) {
                level++;
                if (!q.isEmpty()) {
                    q.offer(new TreeNodePair(null, null));
                }
            } else {
                if (value.left != null) {
                    q.offer(new TreeNodePair(value.left, value));
                }
                if (value.right != null) {
                    q.offer(new TreeNodePair(value.right, value));
                }
                if (parent != null) {
                    value.val = levelSum.get(level) - mp.get(parent);
                } else {
                    value.val = 0;
                }
            }
        }
        return root;
    }
}
