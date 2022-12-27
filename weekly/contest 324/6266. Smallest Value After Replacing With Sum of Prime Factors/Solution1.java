class Solution {
    public int smallestValue(int n) {
        int min = n;
        while (!isPrime(n)) {

            int new_n = f(n);
            if (new_n == n)
                return min;
            n = new_n;
            min = Math.min(min, n);

        }
        return min;
    }

    private boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int f(int num) {
        if (num == 1)
            return num;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return i + f(num / i);
        }
        return num;
    }
}