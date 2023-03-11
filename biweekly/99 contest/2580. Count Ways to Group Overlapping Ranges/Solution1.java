import java.util.*;

class Solution {

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> t = new ArrayList<>();
        for (int[] i : ranges) {
            if (t.size() == 0 || t.get(t.size() - 1)[1] < i[0]) {
                t.add(i);
            } else {
                t.get(t.size() - 1)[1] = Math.max(t.get(t.size() - 1)[1], i[1]);
            }
        }

        int sz = t.size();
        return pow(2, sz, 1000000007);
    }

    public int pow(int i, int j, int p) {
        if (j == 0) {
            return 1;
        }
        if (j == 1) {
            return i % p;
        }
        long t = pow(i, j / 2, p);
        t = (t * t) % p;
        if (j % 2 == 1) {
            t = (t * i) % p;
        }
        return (int) t;
    }
}
