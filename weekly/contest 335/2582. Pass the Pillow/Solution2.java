//HINT : https://leetcode.com/problems/pass-the-pillow/solutions/3258156/java-c-python-one-line-o-1/

class Solution {
    public int passThePillow(int n, int time) {
        // moving forward and backwars, takes n*2-2 steps
        time = time % (n * 2 - 2);
        // now calculate abs dist from n
        return n - Math.abs(n - 1 - time);
    }
}