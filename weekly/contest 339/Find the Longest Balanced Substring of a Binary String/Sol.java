class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

}