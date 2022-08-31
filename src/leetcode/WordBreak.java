package leetcode;

import java.util.*;

public class WordBreak {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        dfs(s, 0, words, new ArrayList<>(),result);
        return result;
    }

    static void dfs(String s , int start, Set<String> words, List<String> subWords, List<String> result){
        if(start == s.length()) {
            result.add(String.join(" ",subWords));
            return;
        }

        for(int i = start ; i < s.length() ; i++){
            String str = s.substring(start , i + 1);
            if(words.contains(str)){
                subWords.add(str);
                dfs(s, i + 1, words, subWords, result);
                subWords.remove(subWords.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("cat");
        arr.add("cats");
        arr.add("and");
        arr.add("sand");
        arr.add("dog");

        List<String> result = wordBreak("catsanddog",arr);

        for(String a : result){
            System.out.println(a + " ");
        }

    }
}
