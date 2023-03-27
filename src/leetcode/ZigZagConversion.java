package leetcode;

import java.util.*;

class ZigZagConversion {

    static String printZigZagConcat(String str, int n)
    {

        if (n == 1) {
            System.out.print(str);
            return str;
        }
        char[] str1 = str.toCharArray();
        int len = str.length();

        String[] arr = new String[n];
        Arrays.fill(arr, "");

        int row = 0;
        boolean down = true;


        for (int i = 0; i < len; ++i) {
            arr[row] = arr[row] +  str1[i];

            if (row == n - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }

        }

        String s = "";
        for (int i = 0; i < n; ++i)
        {
            s = s + arr[i];
        }
        return s;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "PAYPALISHIRING";
        int n = 3;
        System.out.println(printZigZagConcat(str, n));
    }


}
