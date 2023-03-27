package leetcode;

import java.util.HashMap;

public class Word_Pattern {
    public static void main(String[] args) {


        System.out.print(wordPattern("abba", "dog cat cat cat"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(arr[i])) {
                map.put(pattern.charAt(i), arr[i]);
            } else if (!arr[i].equals(map.get(pattern.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
