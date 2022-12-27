import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int l = 0, r = skill.length - 1;
        int sum = skill[l] + skill[r];
        long ans = 0;
        while (l < r) {
            if (skill[l] + skill[r] != sum)
                return -1;
            ans += skill[l] * skill[r];
            l++;
            r--;
        }
        return ans;
    }
}