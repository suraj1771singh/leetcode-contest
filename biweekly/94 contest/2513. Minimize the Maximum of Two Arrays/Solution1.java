//----------------BINARY SEARCH

class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = uniqueCnt1 + uniqueCnt2;
        long high = (int) 1e10;
        long lcm = LCM(divisor1, divisor2);
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            // check all conditions
            boolean a = mid - mid / divisor1 >= uniqueCnt1;
            boolean b = mid - mid / divisor2 >= uniqueCnt2;
            boolean c = mid - mid / lcm >= uniqueCnt1 + uniqueCnt2;
            if (a && b && c) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return (int) ans;
    }

    long gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    long LCM(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

}
// Time complexity : O(log 10^9)