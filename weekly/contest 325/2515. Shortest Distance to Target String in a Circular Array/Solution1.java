
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        String[] arr = new String[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            arr[i] = words[i % n];
        }

        startIndex += n;
        // move left
        int left = -1, right = -1;

        for (int i = startIndex; i >= 0; i--) {
            if (arr[i].equals(target)) {
                left = Math.abs(startIndex - i);
                break;
            }
        }
        // move right
        for (int i = startIndex; i < 3 * n; i++) {
            if (arr[i].equals(target)) {
                right = Math.abs(startIndex - i);
                break;
            }

        }
        return Math.min(left, right);

    }
}
// Time complexity : O(n)
// Space complexity : O(n)