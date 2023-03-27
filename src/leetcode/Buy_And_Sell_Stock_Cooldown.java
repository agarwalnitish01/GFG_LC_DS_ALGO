package leetcode;


import java.util.Arrays;

public class Buy_And_Sell_Stock_Cooldown {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;

        int[] hold = new int[n + 1]; // after buy
        int[] sell = new int[n + 1]; // after sell
        hold[1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], sell[i - 2] - prices[i - 1]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i - 1]);
        }
        return sell[n];
    }

}
