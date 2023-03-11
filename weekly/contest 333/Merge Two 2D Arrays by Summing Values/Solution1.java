import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] a, int[][] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0, ind = 0;
        int res[][] = new int[n1 + n2][2];
        while (i < n1 && j < n2) {
            if (a[i][0] == b[j][0]) {
                res[ind] = new int[] { a[i][0], a[i][1] + b[j][1] };
                i++;
                j++;
            } else if (a[i][0] > b[j][0]) {
                res[ind] = b[j];
                j++;
            } else {
                res[ind] = a[i];
                i++;
            }
            ind++;
        }

        while (i < n1) {
            res[ind++] = a[i++];
        }

        while (j < n2) {
            res[ind++] = b[j++];
        }
        int ans[][] = new int[ind][2];
        for (int k = 0; k < ind; k++) {
            ans[k] = res[k];
        }
        return ans;
    }
}