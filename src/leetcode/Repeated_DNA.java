package leetcode;

import java.util.*;

public class Repeated_DNA {

    public static void main(String[] args) {
        System.out.print(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1)
                list.add(key);
        }
        return list;
    }
}
