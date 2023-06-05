class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int cnt1[] = new int[51];
        int cnt2[] = new int[51];
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            cnt1[a[i]]++;
            cnt2[b[i]]++;
            int sum = 0;
            for (int j = 0; j < 51; j++) {
                sum += Math.min(cnt1[j], cnt2[j]);
            }
            c[i] = sum;
        }
        return c;
    }
}