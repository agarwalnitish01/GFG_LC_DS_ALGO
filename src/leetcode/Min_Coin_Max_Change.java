package leetcode;

class Min_Coin_Max_Change {
    public static int coinChange(int[] coins, int amount) {
        int i = 0, j = 0;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (i = 1; i <= n; i++)
            dp[i][0] = 0;

        for (j = 0; j <= amount; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;

        for (i = 1; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[1][i] = i / coins[0];

            else
                dp[1][i] = Integer.MAX_VALUE - 1;
        }
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= amount; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }

        return (dp[n][amount] == Integer.MAX_VALUE - 1) ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int k = 11;
        System.out.println(coinChange(arr,k));
    }
}
