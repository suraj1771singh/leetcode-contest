
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int initialbit = 0, nextbit = initialbit;
        int n = derived.length;
        for (int i = 0; i < n - 1; i++) {
            nextbit = nextbit ^ derived[i];
        }
        if ((nextbit ^ derived[n - 1]) == initialbit)
            return true;

        initialbit = 1;
        nextbit = initialbit;
        for (int i = 0; i < n - 1; i++) {
            nextbit = nextbit ^ derived[i];
        }
        if ((nextbit ^ derived[n - 1]) == initialbit)
            return true;
        return false;
    }
}