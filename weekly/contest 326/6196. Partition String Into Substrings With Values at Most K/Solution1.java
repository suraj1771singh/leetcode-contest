class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int ans = 0;
        int last = 0;
        String num = "" + s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (Integer.parseInt(num) > k)
                return -1;

            num += s.charAt(i);
            int val = Integer.parseInt(num);
            if (val > k) {
                ans++;
                last = i;
                num = "" + s.charAt(i);
            }
        }
        int val = Integer.parseInt(num);
        if (val > k && last == n - 1) {
            ans++;
        }
        return ans;
    }
}