package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Word_Ladder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordSet.remove(beginWord);
        int level = 1;
        while (!reached.isEmpty()) {
            Set<String> reachedNext = new HashSet<>();
            for (String s : reached) {
                for (int i = 0; i < s.length(); i++) {
                    char[] c = s.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        c[i] = j;
                        String newS = new String(c);
                        if (wordSet.remove(newS)) {
                            reachedNext.add(newS);
                            if (endWord.equals(newS))
                                return level + 1;
                        }
                    }
                }
            }
            reached = reachedNext;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> avc = new ArrayList<>();
        avc.add("hot");
        avc.add("dot");
        avc.add("dog");
        avc.add("lot");
        avc.add("log");
        avc.add("cog");
        System.out.println(ladderLength("hit", "cog", avc));
    }
}
