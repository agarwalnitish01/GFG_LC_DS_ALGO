package leetcode;

import java.util.*;

public class Word_Break_Backtracking {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        dfs(s,  words, new ArrayList<>(),result,0);
        return result;
    }

    static void dfs(String s , Set<String> wordDict, List<String> current, List<String> result, int j){
        if(j == s.length()) {
            result.add(String.join(" ",current));
            return;
        }

        for(int i = j ; i < s.length() ; i++){
            String str = s.substring(j , i + 1);
            if(wordDict.contains(str)){
                current.add(str);
                dfs(s,  wordDict, current, result, i + 1);
                current.remove(current.size()-1);
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
