class Solution {
    public boolean isCircularSentence(String sentence) {
        String str = sentence.trim();
        String arr[] = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String s1 = arr[i];
            String s2 = arr[(i + 1) % arr.length];
            if (s1.charAt(s1.length() - 1) != s2.charAt(0))
                return false;
        }
        return true;

    }
}