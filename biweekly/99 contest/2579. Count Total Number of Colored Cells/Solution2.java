/*
Ans is sum of arithmatic of 4 of (n-1) terms + 1.
for n = 1, ans = 1
for n = 2, ans = 1 + 4
for n = 3, ans = 1 + 4 + 8
for n = 4, ans = 1 + 4 + 8 + 12

So from above observation we conclude that 
we need to return 1+ (arithmatic sum of first n-1 terms of 4)
*/

class Solution {
public:
    long long coloredCells(int n) {
        if(n == 1) return 1;
        long long t  = n-1;
        return 1 + (t * (8 + (t-1)*4))/2;
    }
};