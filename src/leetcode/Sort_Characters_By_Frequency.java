package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.length() - a.length());


        for (char i : s.toCharArray()) {
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }


        for (Character i : map.keySet()) {
            StringBuilder br = new StringBuilder();

            int len = map.get(i);
            for (int j = 0; j < len; j++) {
                br.append(i);
            }
            pq.add(br.toString());
        }

        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            answer.append(pq.poll());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.print(frequencySort("tree"));
    }
}
