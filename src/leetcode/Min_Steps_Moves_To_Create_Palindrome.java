package leetcode;

import java.util.HashMap;

public class Min_Steps_Moves_To_Create_Palindrome {

    public static int minMovesToMakePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int odd = 0;
        int left = 0;
        int right = s.length() - 1;
        int result = 0;

        char[] strArray = s.toCharArray();
        for (char c : strArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                odd++;
            }
        }

        if (odd > 1) {
            return -1;
        }

        while (left < right) {
            int l = left;
            int r = right;
            while (s.charAt(l) != s.charAt(r)) {
                r--;
            }
            if (l == r) {

                // when we found odd element
                char ch1 = s.charAt(r), ch2 = s.charAt(r + 1);
                s = s.substring(0, r) + ch2
                        + ch1 + s.substring(r + 2);
                result++;
                continue;
            } else {
                while (r < right) {
                    char ch1 = s.charAt(r), ch2 = s.charAt(r + 1);
                    s = s.substring(0, r) + ch2
                            + ch1 + s.substring(r + 2);
                    result++;
                    r++;
                }
            }
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(minMovesToMakePalindrome("aabb"));
    }
}
