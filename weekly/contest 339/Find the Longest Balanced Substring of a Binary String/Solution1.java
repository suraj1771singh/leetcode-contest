class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int len = 0, cnt = 0, ind = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                continue;
            int zeros = 0, ones = 0;
            int j = i;
            for (j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    break;
                zeros++;

            }
            for (int k = j; k < s.length(); k++) {
                if (s.charAt(k) == '0')
                    break;
                ones++;

            }
            len = Math.max(len, 2 * Math.min(zeros, ones));

        }
        return len;
    }
}