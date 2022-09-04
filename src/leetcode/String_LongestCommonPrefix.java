package leetcode;

class String_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (String str : strs) {
            while (str.indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"flower","fl","flight"};
        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommonPrefix2(arr));
    }

    public static String longestCommonPrefix2(String[] arr) {
        String prefix = arr[0];

        for (int i = 1; i <= arr.length - 1; i++) {
            prefix = commonPrefixUtil(prefix, arr[i]);
        }

        return (prefix);
    }

    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }
}
