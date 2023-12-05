package leetcode;

import Different.PairKeyValueInteger;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<PairKeyValueInteger<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        for (int key : map.keySet()) {
            queue.offer(new PairKeyValueInteger<>(key, map.get(key)));
        }

        int[] ans = new int[k];
        int idx = 0;

        while (k > 0) {
            ans[idx++] = queue.poll().getKey();
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 3};
        for (int a : topKFrequent(num, 2)) {
            System.out.print(a + " ");
        }

    }
}
