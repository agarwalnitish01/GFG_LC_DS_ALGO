package leetcode;
import java.util.*;

class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : nums) {
            Integer value = map.getOrDefault(c, 0);
            if (value == 1) {
                return true;
            }
            map.put(c, value + 1);
        }
        return false;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,1};

        System.out.println(containsDuplicate(arr));
    }
}