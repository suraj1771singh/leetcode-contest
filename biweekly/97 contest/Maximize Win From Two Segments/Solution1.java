import java.util.*;

class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ttl = 0;
        for (int i : prizePositions) {
            map.put(i, ++ttl);
        }
        System.out.println(map);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ttl = 0;
        intf 
        for (int key : map.keySet()) {
            ttl += map.get(key);
            key = key - (k + 1);
            if (map.floorKey(key) != null) {
                pq.add(ttl - map.floorKey(key));
            }
            if (pq.size() > 2)
                pq.poll();

        }
        int cnt = 0;
        while (!pq.isEmpty())
            cnt += pq.poll();
        return (int) Math.min(cnt, prizePositions.length);

    }
}