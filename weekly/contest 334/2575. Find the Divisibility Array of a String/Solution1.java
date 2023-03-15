class Solution {
    public int[] divisibilityArray(String word, int m) {
        long carry=0;
        int n= word.length();
        int ans[]= new int[n];
        for(int i=0; i<n; i++){
            carry = carry*10 + Character.getNumericValue(word.charAt(i));
            ans[i] = carry%m==0 ? 1 : 0;
            carry%=m;
        }
        return ans;
    }
}
//Time complexity : O(n)