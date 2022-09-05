package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> stringListMap = new HashMap<>();
        for(String a : strs){
            char []arr = a.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if(stringListMap.containsKey(sorted)){
                stringListMap.get(sorted).add(a);
            } else {
                List<String> strings1 = new ArrayList<>();
                strings1.add(a);
                stringListMap.put(sorted,strings1);
            }
        }

        return new ArrayList<>(stringListMap.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> resultList = groupAnagrams2(strings);
        for (List<String> strings1 : resultList) {
            for(String a : strings1){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
