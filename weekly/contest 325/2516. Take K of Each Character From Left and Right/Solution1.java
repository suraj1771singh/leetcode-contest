// ALGO
/* 
    let ttl_cnt_a represent total count of 'a' in string. similary we have ttl_cnt_b, ttl_cnt_c.
    Idea is to find longest subarray where
    ttl_cnt_a - cnt_a>=k and
    ttl_cnt_b- cnt_b>=k and
    ttl_cnt_c- cnt_c>=k
    where cnt_a, cnt_b, and cnt_c are count of characters inside subarray.
    Instead of taking variables we can take an array cnt1 and cnt2
    cnt1 : freq of a,b,c in word
    cnt2 : freq of a, b,c in subarray
    and we need to maximize subarray such that
    cnt1[i]-cnt2[i] >= k
    or
    cnt2[i] > cnt1[i]-k
 */

class Solution {
    public int takeCharacters(String s, int k) {
        int cnt1[] = new int[3];
        int cnt2[] = new int[3];
        int n = s.length();
        for (int i = 0; i < n; i++)
            cnt1[s.charAt(i) - 'a']++;

        if (!isValid(cnt1, cnt2, k))
            return -1;

        int l = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            cnt2[s.charAt(i) - 'a']++;
            if (isValid(cnt1, cnt2, k)) {
                count++;
            } else {
                cnt2[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return n - count;
    }

    public boolean isValid(int cnt1[], int[] cnt2, int k) {
        for (int i = 0; i < 3; i++) {
            if (cnt2[i] > cnt1[i] - k)
                return false;
        }
        return true;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)