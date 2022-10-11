package leetcode;

class Break_Palindrome {
    public static String breakPalindrome(String s) {

        if (s.length() == 1)
            return "";

        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (i != j) {
                if (arr[i] != 'a') {
                    arr[i] = 'a';
                    return String.valueOf(arr);
                }
            }
        }
        //If all chars in array are 'a' -> change the last char into 'b'
        arr[n - 1] = 'b';
        return String.valueOf(arr);
    }

    public static void main(String args[]) {
        System.out.print(breakPalindrome("abccba"));
    }
}
