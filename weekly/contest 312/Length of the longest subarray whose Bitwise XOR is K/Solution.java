
import java.util.*;

class Main {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println(LongestLenXORK(arr, k));
    }

    public static int LongestLenXORK(int arr[], int k) {
        int max_len = 0, xorr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xorr ^= arr[i];
            if (map.containsKey(xorr ^ k))
                max_len = Math.max(max_len, i - map.get(xorr ^ k));
            if (!map.containsKey(xorr))
                map.put(xorr, i);
        }
        return max_len;
    }
}