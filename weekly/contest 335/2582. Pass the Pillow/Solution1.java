class Solution {
    public int passThePillow(int n, int time) {
        int ind = 1;
        boolean reverse = false;
        while (time-- > 0) {

            if (reverse) {
                if (ind > 1)
                    ind--;
                else {
                    ind++;
                    reverse = false;
                }

            } else {
                if (ind < n)
                    ind++;
                else {
                    ind--;
                    reverse = true;
                }
            }

        }

        return ind;
    }
}