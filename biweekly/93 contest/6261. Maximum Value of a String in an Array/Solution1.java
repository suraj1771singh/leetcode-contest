class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            int val = 0;
            if (contiansAlphaNum(str))
                val = str.length();
            else
                val = Integer.parseInt(str);
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private boolean contiansAlphaNum(String str) {
        boolean isNum = false;
        boolean isAlpha = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 64) {
                // System.out.println((int)str.charAt(i));
                return true;
            }

        }
        return false;
    }
}