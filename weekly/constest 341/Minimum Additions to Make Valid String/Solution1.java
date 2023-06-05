class Solution {
    public int addMinimum(String word) {
        char ch[] = word.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            char c = ch[i];
            if (c == 'a') {
                int j = i + 1;
                if (ch[j] == 'b') {

                } else
                    ans++;
            }
        }
    }
}