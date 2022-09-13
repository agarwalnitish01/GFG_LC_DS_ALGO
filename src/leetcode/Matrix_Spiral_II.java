package leetcode;


import java.util.ArrayList;
import java.util.List;

class Matrix_Spiral_II {

    // Function to print in spiral order
    public static int[][] spiralOrder(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            // traverse from left to right
            for (int j = i; j < n - i; j++) {
                res[i][j] = count++;
            }
            // traverse from top to bottom
            for (int j= i + 1; j < n - i; j++) {
                res[j][n - i - 1] = count++;
            }
            //  traverse from right to left
            for (int j = i + 1; j < n - i;j++) {
                res[n - i - 1][n - j- 1] = count++;
            }
            //  traverse from bottom to top
            for (int j = i + 1; j < n - i - 1; j++) {
                res[n - j - 1][i] = count++;
            }
        }
        return res;
    }


    // Driver Code
    public static void main(String[] args) {
        int[][] res = spiralOrder(3);
        for(int[] a : res){
            for(int b : a){
                System.out.print(b);
            }
            System.out.println();
        }

    }

}

