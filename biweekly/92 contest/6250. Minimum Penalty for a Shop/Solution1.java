class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'Y')
                arr[i] = 1;
        }
        int prefix[] = new int[n];

        // creating prefix array
        prefix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            prefix[i] += prefix[i + 1] + arr[i];

        int ans = 0;
        int maxi = prefix[0];
        int prev = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 0)
                prev++;
            int temp = prefix[i + 1] + prev;
            if (temp < maxi) {
                maxi = temp;
                ans = i + 1;
            }
        }
        if (arr[n - 1] == 0)
            prev++;

        if (prev < maxi)
            ans = n;

        return ans;
    }

}