class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums1.length;
        int xorr = 0;
        if (n1 % 2 == 0 && n2 % 2 == 0) {
            return 0;
        } else if (n1 % 2 != 0 && n2 % 2 != 0) {
            for (int i : nums1)
                xorr ^= i;

            for (int i : nums2)
                xorr ^= i;

        } else if (n1 % 2 == 0 && n2 % 2 != 0) {
            for (int i : nums1)
                xorr ^= i;

        } else
            for (int i : nums2)
                xorr ^= i;
        return xorr;
    }
}