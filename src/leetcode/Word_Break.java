package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Word_Break {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("leetc");
        arr.add("leet");
        arr.add("code");


        System.out.println(wordBreak("leetcode", arr));


    }

    public static boolean wordBreak(String s, List<String> dict) {

        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 0; i < s.length(); i++) {

            if (t[i]==false) {
                continue;
            }
            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }
                if (t[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }
}
