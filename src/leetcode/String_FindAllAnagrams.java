package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        Map<Character, Integer> anagram = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            anagram.put(p.charAt(i), anagram.getOrDefault(p.charAt(i), 0) + 1);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (anagram.equals(map)) {
                arr.add(i);
            }
            char start = s.charAt(i);
            if (map.get(start) == 1) {
                map.remove(start);  
            } else {
                map.put(start, map.get(start) - 1); 
            }
            char end = s.charAt(i + p.length());
            map.put((end), map.getOrDefault(end, 0) + 1);
        }
        if (anagram.equals(map)) { 
            arr.add(s.length() - p.length());
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> integers = findAnagrams("cbaebabacd", "abc");
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
