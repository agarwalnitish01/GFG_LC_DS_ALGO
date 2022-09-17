package leetcode;

import java.util.*;

public class Palindrome_Pairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            wordMap.put(words[i], i);
            set.add(words[i].length());
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int length = words[i].length();

            if (length == 1) {
                if (wordMap.containsKey("")) {
                    ans.add(Arrays.asList(i, wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                ans.add(Arrays.asList(i, wordMap.get(reverse)));

            int j = 0;
            while (j < reverse.length() - 1) {
                String rev = reverse.substring(0, j + 1);
                if (wordMap.containsKey(rev)) {
                    String rem = words[i].substring(0, words[i].length() - j - 1);
                    if (isPalindrome(rem)) {
                        ans.add(Arrays.asList(wordMap.get(reverse.substring(0, j + 1)),i));
                    }
                }
                j++;
            }

            int k = 0;
            while (k < words[i].length() - 1) {
                String rev = new StringBuilder(words[i].substring(0, k + 1)).reverse().toString();
                if (wordMap.containsKey(rev)) {
                    String rem = words[i].substring(k + 1);
                    if (isPalindrome(rem)) { ;
                        ans.add(Arrays.asList(i,wordMap.get(rev)));
                    }
                }
                k++;
            }
        }
        return ans;
    }

    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = {"abcd", "dcba", "lls", "s", "sssll"};

        System.out.print(palindromePairs(arr));
    }
}
