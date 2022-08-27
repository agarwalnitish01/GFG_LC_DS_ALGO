package leetcode;
import java.util.*;
class MaxSubArray_Matrix_Sum_K_rows {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<m; i++){
            int[] sum = new int[n];

            for(int j = i; j<m; j++){

                for(int r = 0; r<n; r++){
                    sum[r] += matrix[r][j];
                }

                int currMax = findMaxSubarraySum(sum,k);
                maxSum = Math.max(currMax, maxSum);
            }
        }

        return maxSum;
    }

    public static int findMaxSubarraySum(int a[], int k) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int tsum = 0;
            for (int j = i; j < a.length; j++) {
                tsum += a[j];
                if (tsum <= k)
                    max = Math.max(max, tsum);
            }
        }
        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                      {14,15,16},
                      {27,28,29}};
        System.out.println(maxSumSubmatrix(arr, 20));
    }
}
