import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++)
            list.add(new People(names[i], heights[i]));

        Collections.sort(list, (a, b) -> b.height - a.height);

        String[] ans = new String[heights.length];
        for (int i = 0; i < heights.length; i++) {
            ans[i] = list.get(i).name;
        }
        return ans;

    }
}

class People {
    String name;
    int height;

    People(String a, int b) {
        name = a;
        height = b;
    }
}