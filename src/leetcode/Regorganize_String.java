package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Regorganize_String {

    /*
//https://leetcode.com/problems/reorganize-string/solutions/5652992/heap-hashmap-solution/

    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.


Example 1:

Input: s = "aab"
Output: "aba"

Time complexity:O(n log k)

Space complexity:O(k)
     */

    public static String reorganizeString(String s) {
        if(s.length()==1)
            return s;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        for( int value : map.values()){
            if(value>=s.length()+1/2)
                return "";
        }
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a, b)->map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());
        char prev = '?';
        StringBuilder result = new StringBuilder();
        while(!maxheap.isEmpty()){
            char current = maxheap.poll();
            result.append(current);
            map.put(current, map.get(current)-1);
            if(prev!='?' && map.get(prev)>0){
                maxheap.add(prev);
            }
            prev = current;
        }
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
