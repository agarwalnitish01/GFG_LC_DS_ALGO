package leetcode;
import java.util.*;

public class String_ransomNote {
    public static void main(String args[]){
        String input = "aa";
        String mag = "aab";
        System.out.println(isRansomNote(input, mag));
    }

    private static boolean isRansomNote(String input, String mag) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char c : input.toCharArray()) {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(char c : mag.toCharArray()) {
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        for(char c : map1.keySet()){
            Integer count = map2.get(c);
            if(count==null || count<map1.get(c)){
                return false;
            }
        }

        return true;
    }
}
