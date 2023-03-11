class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int[] a = new int[nums1.length];
        long sum = 0;
        long cnt = 0;
        for (int i = 0; i < nums1.length; ++i) {
            a[i] = nums2[i] - nums1[i];
            if (k == 0 && a[i] != 0)
                return -1;
            if (k == 0 && a[i] == 0)
                continue;
            if (Math.abs(a[i]) % k != 0)
                return -1;
            if (a[i] >= 0)
                cnt += a[i];
            sum += a[i];
        }
        if (sum != 0)
            return -1;
        if (k == 0 && cnt != 0)
            return -1;
        if (k == 0 && cnt == 0)
            return 0;

        return cnt / k;
    }
}