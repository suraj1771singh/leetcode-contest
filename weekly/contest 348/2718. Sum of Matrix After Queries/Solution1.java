class Solution {
    public long matrixSumQueries(int n, int[][] queries) {

        boolean seenCol[] = new boolean[n];
        boolean seenRow[] = new boolean[n];
        int setCol = 0, setRow = 0;
        long sum = 0;

        for (int i = queries.length - 1; i >= 0; i--) {
            int q[] = queries[i];
            if (q[0] == 1) {
                // col
                if (!seenCol[q[1]]) {
                    sum += (n - setRow) * q[2];
                    setCol++;
                    seenCol[q[1]] = true;
                }

            } else {
                // row
                if (!seenRow[q[1]]) {
                    sum += (n - setCol) * q[2];
                    setRow++;
                    seenRow[q[1]] = true;
                }
            }
        }
        return sum;
    }
}