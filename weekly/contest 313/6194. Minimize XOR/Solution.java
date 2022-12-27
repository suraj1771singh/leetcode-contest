class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt = numberOfSetBits(num2);
        System.out.println("set bit " + cnt);
        int num = num1;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0 && cnt > 0) {
                System.out.println("bit " + i);
                num &= ~(1 << i);
                cnt--;
            }
        }
        int ans = num ^ num1;
        while (cnt > 0) {
            for (int i = 0; i > 31; i++) {
                if ((ans & (1 << i)) == 0 && cnt > 0) {
                    ans |= 1 << i;
                    cnt--;
                }
            }
        }
        return ans;

    }

    public static int numberOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;

    }
}