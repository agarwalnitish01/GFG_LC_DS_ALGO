package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_Letter_Case_Permutations {

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        generatePermutations(0, S, result);
        return result;
    }

    public static void generatePermutations(int j, String str, List<String> result) {
        result.add(str);

        for (int i = j; i < str.length(); i++) {
            char[] wordArr = str.toCharArray();
            if (Character.isLetter(wordArr[i])) {
                if (Character.isUpperCase(wordArr[i])) {
                    wordArr[i] = Character.toLowerCase(wordArr[i]);
                } else {
                    wordArr[i] = Character.toUpperCase(wordArr[i]);
                }
                generatePermutations(i + 1, String.valueOf(wordArr), result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCasePermutation("a1b2");

        for(String a : result)
            System.out.print(a + " ");
    }
}
