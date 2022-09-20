package leetcode;


import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(minFallingPathSum2(mat));
    }

    public static int minFallingPathSum2(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // initialize
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){

                int min = dp[i - 1][j];//bottom
                if (j >= 1){
                    min = Math.min(min, dp[i - 1][j - 1]);//left bottom
                }
                if (j + 1 < n){
                    min = Math.min(min, dp[i - 1][j + 1]);//right bottom
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        // find the minimum sum in last row.
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}
