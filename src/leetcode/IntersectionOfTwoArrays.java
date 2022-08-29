package leetcode;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args){
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        int[] res = intersect2(arr1,arr2);

        for(int a : res)
            System.out.println(a + " ");

    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int value : nums1) {
            map.put(value, map.getOrDefault(value,0) + 1);
        }

        for (int value : nums2) {
            if (map.containsKey(value)) {
                list.add(value);
                map.put(value, map.get(value) - 1);
                if (map.get(value) == 0)
                    map.remove(value);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int k=0;
        for(int a : nums1){
            set.add(a);
        }

        for(int a : nums2){
            if(set.contains(a)){
                set2.add(a);
            }
        }

        return set2.stream().mapToInt(Integer::intValue).toArray();
    }
}
