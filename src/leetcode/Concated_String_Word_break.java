package leetcode;

import java.util.*;

public class Concated_String_Word_break {
    public static void main(String[] args) {
        String[] arr = {"leetc","leet","code"};

        System.out.println(findAllConcatenatedWordsInADict(arr));


    }



    public static List<String> findAllConcatenatedWordsInADict(String words[]) {
        HashSet<String> hs = new HashSet<>();
        Collections.addAll(hs, words);
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            hs.remove(s);
            boolean a = wrdBrk(hs,s, new HashMap<>());
            if (a) {
                ans.add(s);
            }
            hs.add(s);
        }
        return ans;
    }

    public static boolean wrdBrk(HashSet<String> hs,String str, HashMap<String, Boolean> memo) {
        if (str.length() == 0) {
            return true;
        }
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        if (hs.contains(str)) {
            return true;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            String left = str.substring(0, i + 1);
            if (hs.contains(left)) {
                String right = str.substring(i + 1);
                boolean smallAns = wrdBrk(hs,right, memo);
                if (smallAns) {
                    memo.put(str, true);
                    return true;
                }
            }
        }
        memo.put(str, false);
        return false;
    }
}
