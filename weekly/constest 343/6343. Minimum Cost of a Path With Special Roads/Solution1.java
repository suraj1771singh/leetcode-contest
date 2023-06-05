import java.util.*;

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length;

        for (int i = 0; i < n; i++) {
            int a[] = specialRoads[i];
            if (a[2] < a[0] || a[3] < a[1]) {
                int temp = a[2];
                a[2] = a[0];
                a[0] = temp;

                temp = a[3];
                a[3] = a[1];
                a[1] = temp;
            }
        }

        Integer dp[][] = new Integer[n + 1][n + 1];
        Arrays.sort(specialRoads, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int a[] : specialRoads)
            System.out.print(Arrays.toString(a) + " ");
        System.out.println();
        return f(0, -1, start, target, specialRoads, dp);
    }

    int f(int curr, int prev, int start[], int[] target, int sp[][], Integer dp[][]) {

        if (curr >= sp.length) {
            if (prev != -1)
                return Math.abs(sp[prev][2] - target[0]) + Math.abs(sp[prev][3] - target[1]);
            else
                return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
        }
        if (dp[curr][prev + 1] != null)
            return dp[curr][prev + 1];
        int p = 0, np = 0;
        // pick
        if (prev == -1) {
            p = Math.abs(start[0] - sp[curr][0]) + Math.abs(start[1] - sp[curr][1]) + sp[curr][4]
                    + f(curr + 1, curr, start, target, sp, dp);
        } else {
            p = Math.abs(sp[prev][2] - sp[curr][0]) + Math.abs(sp[prev][3] - sp[curr][1]) + sp[curr][4]
                    + f(curr + 1, curr, start, target, sp, dp);
        }
        // not pick
        np = f(curr + 1, prev, start, target, sp, dp);
        return dp[curr][prev + 1] = Math.min(p, np);
    }
}