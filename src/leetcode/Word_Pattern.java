package leetcode;

import java.util.HashMap;

public class Word_Pattern {
    public static void main(String[] args) {


        System.out.print(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" ");
        if (pattern.length() != list.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(list[i])) {
                map.put(pattern.charAt(i), list[i]);
            } else if (!list[i].equals(map.get(pattern.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
