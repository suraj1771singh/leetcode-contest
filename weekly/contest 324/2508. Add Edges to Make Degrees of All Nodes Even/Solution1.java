import java.util.*;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0) - 1).add(edge.get(1) - 1);
            adj.get(edge.get(1) - 1).add(edge.get(0) - 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() % 2 == 1)
                list.add(i);
        }
        if (list.size() == 0)
            return true;

        if (list.size() % 2 == 1 || list.size() > 4) // if size is odd
            return false;
        // if size if even
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == -1)
                continue;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == -1)
                    continue;
                if (!adj.get(list.get(i)).contains(list.get(j))) {
                    list.set(i, -1);
                    list.set(j, -1);
                    break;
                }
                boolean flag = false;
                for (int k = 0; k < n; k++) {
                    if (!adj.get(list.get(i)).contains(k) && !adj.get(list.get(j)).contains(k)
                            && adj.get(k).size() % 2 == 0) {
                        list.set(i, -1);
                        list.set(j, -1);
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;

            }
        }
        for (int i : list)
            if (i != -1)
                return false;
        return true;

    }
}
// Time complexity : O(edges)
// Space complexity : O(edges)