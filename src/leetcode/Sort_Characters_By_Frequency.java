package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.length() - a.length());


        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }


        for (Character i : map.keySet()) {
           String br = "";
            for (int j = 0; j < map.get(i); j++) {
                br= br + i;
            }
            pq.add(br);
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
