package leetcode;

import java.util.Arrays;


public class Buy_And_Sell_Stock_III_IV {
    public static void main(String[] args) {
        int[] arr = {3,2,6,5,0,3};
        System.out.println(maxProfit(2,arr));
        System.out.println(maxProfit2(2,arr));
        int[] arr2 = {1, 4, 5, 7, 6, 3, 2, 9};
        System.out.println(maxProfit_2_Transactions(arr2));
    }

    public static int maxProfit(int k, int[] prices) {
        int[] dp = new int[2*k+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;

        for(int j = 0; j < prices.length; j++) {

            for(int i = 0; i+2 <= 2*k; i += 2){

                dp[i+1] = Math.max(dp[i+1], dp[i]-prices[j]);
                dp[i+2] = Math.max(dp[i+2], dp[i+1]+prices[j]);
            }
        }
        return dp[dp.length-1];
    }

    public static int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++)
            {
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(max + prices[j], dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }

    public static int maxProfit_2_Transactions(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[n - 1] = 0;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;

    }

}
