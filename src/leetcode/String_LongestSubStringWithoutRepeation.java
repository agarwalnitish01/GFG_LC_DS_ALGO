package leetcode;

import java.util.*;

public class String_LongestSubStringWithoutRepeation {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestUniqueSubsttr("abcabcbb"));
        System.out.println(longestUniqueSubsttr1("abcabcbb"));
    }

    //abcabcbba
    static int longestUniqueSubsttr1(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int maximum_length = Integer.MIN_VALUE;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c)+1);
            }
            map.put(c, i);
            maximum_length = Math.max(maximum_length, i-start+1 );
        }
        return maximum_length;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        String maxSub = "";
        int maxLen = 0;

        for(int i = 0 ;i<s.length();i++) {
            for (int j = i; j <= s.length(); j++) {
                String a = s.substring(i,j);
                if(isDistinctString(a)){
                    if(a.length()>maxLen) {
                        maxSub = a;
                        maxLen = a.length();
                    }
                }
            }
        }
        return maxLen;
    }


    private static boolean isDistinctString(String input){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : input.toCharArray()){
            Integer value = map.getOrDefault(c,0);
            if(value==1){
                return false;
            }
            map.put(c,value+1);
        }
        return true;
    }




    public static int longestUniqueSubsttr(String str)
    {
        String test = "";

        int maxLength = -1;

        if (str.isEmpty()) {
            return 0;
        }
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)+ 1);
            }
            test = test + c;
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }


}
