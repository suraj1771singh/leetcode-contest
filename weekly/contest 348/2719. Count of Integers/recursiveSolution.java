//-------------------------DIGIT DP
class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int n1 = num1.length(), n2 = num2.length();
        int d = n2 - n1;
        StringBuilder str = new StringBuilder(num1);
        while (d-- > 0)
            str.insert(0, '0');
        num1 = str.toString();

        int ans = f(0, 1, 1, max_sum, num1, num2) - f(0, 1, 1, min_sum - 1, num1, num2);
        return ans;
    }

    int f(int ind, int f1, int f2, int sum, String a, String b) {
        if (sum < 0)
            return 0;
        if (ind >= b.length())
            return 1;

        // f1 : are all previous digit are at their minimum possible digit ?
        // f2 : are all previous digit are at their maximum possible digit ?
        int start = f1 == 1 ? a.charAt(ind) - '0' : 0;
        int end = f2 == 1 ? b.charAt(ind) - '0' : 9;
        int res = 0;

        for (int dgt = start; dgt <= end; dgt++) {
            int nf1 = f1 == 1 && dgt == start ? 1 : 0;
            int nf2 = f2 == 1 && dgt == end ? 1 : 0;
            res += f(ind + 1, nf1, nf2, sum - dgt, a, b);
        }
        return res;
    }
}