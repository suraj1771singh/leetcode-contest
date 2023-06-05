class Solution {
    public int distMoney(int m, int c) {
        int cnt = 0;
        if (m < c)
            return -1;
        while (m >= 8 && m > c && c > 0) {
            if (m >= 8) {
                m -= 8;
                cnt++;

            }
            c--;
        }
        if (m < c) {
            while (m < c) {

                cnt--;
                m += 8;
            }
            return cnt;
        }
        if (m == 4 && c == 1)
            return cnt - 1;
        if (m > 0 && c == 0)
            return cnt - 1;
        return cnt;

    }
}