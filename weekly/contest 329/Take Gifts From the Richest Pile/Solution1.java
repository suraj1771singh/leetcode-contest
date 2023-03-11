import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : gifts)
            pq.add(i);
        while (k-- > 0) {
            int item = pq.poll();
            item = (int) Math.sqrt((double) item);
            pq.add(item);
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;

    }
}