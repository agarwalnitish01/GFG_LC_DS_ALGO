package leetcode;

import java.util.Arrays;

class ZigZagConversion {

    // Prints concatenation
    // of all rows of str's
    // Zig-Zag fashion
    static void printZigZagConcat(String str,
                                  int n)
    {
        char[] arr = new char[str.length()];


        for (int i = 0; i < n; ++i)
        {
            System.out.print(arr[i]);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "GEEKSFORGEEKS";
        int n = 3;
        printZigZagConcat(str, n);
    }
}
