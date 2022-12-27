//optmized solution

public class Solution2 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int left = 1;
        int right = 1;
        int n = words.length;
        if (words[startIndex].equals(target))
            return 0;
        int r = startIndex + 1;
        int l = startIndex - 1;
        r = r % n;
        l = (n + l) % n;
        // move right
        while (r != startIndex) {
            if (words[r].equals(target))
                break;
            r++;
            r %= n;
            right++;
        }
        // move left
        while (l != startIndex) {
            if (words[l].equals(target))
                break;
            l--;
            l = (n + l) % n;
            left++;
        }
        if (left == n && right == n)
            return -1;
        else
            return Math.min(left, right);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)
