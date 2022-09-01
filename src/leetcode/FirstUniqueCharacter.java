package leetcode;
import java.util.*;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0 ;i< chars.length; i++) {
            if(map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

}
