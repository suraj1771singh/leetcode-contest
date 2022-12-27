import java.util.*;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<Creator> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++)
            map.put(creators[i], map.getOrDefault(creators[i], 0) + views[i]);

        for (int i = 0; i < creators.length; i++) {
            Creator obj = new Creator(creators[i], ids[i], views[i], map.get(creators[i]));
            list.add(obj);
        }

        Collections.sort(list, new Comparator<Creator>() {
            public int compare(Creator a, Creator b) {
                if (a.ttl_views != b.ttl_views) {
                    return b.ttl_views - a.ttl_views;
                }
                if (a.views != b.views)
                    return b.views - a.views;
                return a.id.compareTo(b.id);
            }
        });

        int max_view = list.get(0).ttl_views;
        String curr_creator = list.get(0).name;

        // add 0th index creator to ans
        List<String> temp = new ArrayList<>();
        temp.add(curr_creator);
        temp.add(list.get(0).id);
        ans.add(temp);

        for (int i = 1; i < list.size(); i++) {
            Creator item = list.get(i);
            if (!item.name.equals(curr_creator) && item.ttl_views == max_view) {
                curr_creator = item.name;
                temp = new ArrayList<>();
                temp.add(item.name);
                temp.add(item.id);
                ans.add(temp);
            }
        }
        return ans;

    }
}

class Creator {
    String name;
    String id;
    int views;
    int ttl_views;

    Creator(String a, String b, int c, int d) {
        name = a;
        id = b;
        views = c;
        ttl_views = d;
    }

    public void increViews(int a) {
        ttl_views += a;
    }
}