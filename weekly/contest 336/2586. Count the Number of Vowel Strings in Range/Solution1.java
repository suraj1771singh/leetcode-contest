class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int n= words.length;
        
        int ans=0;
        for(int i=left ; i<=right; i++){
            String s=words[i];
            int len= s.length();
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(len-1)) ) ans++;
            
        }
        return ans;
    }
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
}