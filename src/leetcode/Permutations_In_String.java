package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Permutations_In_String {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abcdxabcde","abcdeabcdx"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)
            return false;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> actualMap = new HashMap<>();
        for(char c : s1.toCharArray()){
            actualMap.put(c,actualMap.getOrDefault(c,0)+1);
        }


        for(int i=0; i< n1; i++){
            char c = s2.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        if(actualMap.equals(map)){
            return true;
        }

        for(int i=n1;i<n2;i++){
            char removeC = s2.charAt(i-n1);
            char addC = s2.charAt(i);
            if(map.containsKey(removeC)){
                int freq = map.get(removeC);
                if(freq==1){
                    map.remove(removeC);
                }else{
                    map.put(removeC,freq-1);
                }
            }
            map.put(addC,map.getOrDefault(addC,0)+1);
            if(actualMap.equals(map)){
                return true;
            }
        }


        return false;
    }
}
