import java.util.*;

class LUPrefix {
    int longest = 0;
    Set<Integer> set;

    public LUPrefix(int n) {
        set = new HashSet<>();
    }

    public void upload(int video) {
        set.add(video);
        while (set.contains(longest + 1)) {
            longest++;
            set.remove(longest - 1);
        }
    }

    public int longest() {
        return longest;
    }
}