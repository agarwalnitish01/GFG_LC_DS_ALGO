package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestPalindromeSubstring("cccc"));
        System.out.println(lengthOfLongestPalindromeSubstring2("cccc"));
    }

    public static String lengthOfLongestPalindromeSubstring(String s) {
        if(s.length()==1){
            return s;
        }
        String maxSub = "";
        int maxLen = 0;

        for(int i = 0 ;i<s.length();i++) {
            for (int j = i; j <= s.length(); j++) {
                String a = s.substring(i,j);
                if(isPalindrome(a)){
                    if(a.length()>maxLen) {
                        maxSub = a;
                        maxLen = a.length();
                    }
                }
            }
        }
        return maxSub;
    }


    static boolean isPalindrome(String str)
    {

        int i = 0, j = str.length() - 1;

        while (i < j) {

            if (str.charAt(i) != str.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    public static String lengthOfLongestPalindromeSubstring2(String str) {
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        boolean[][] table = new boolean[n][n];

        maxLength = 1;
        for(int i = 0 ;i<n;i++){
            table[i][i] = true;
        }

        for(int i = 0 ;i<n-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                start = i;
                table[i][i+1] = true;
                maxLength = 2;
            }
        }

        for(int k =3;k<=n;k++){
            for(int i = 0 ;i<n-k+1;i++){
                int j = i+k-1;

                if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)){
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start,start+maxLength);
    }
}
