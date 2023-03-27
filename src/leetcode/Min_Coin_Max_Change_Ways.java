package leetcode;

class Min_Coin_Max_Change_Ways {
    public static int change(int amount, int[] coins) {
        int [] dp = new int[amount+1];

        dp[0] = 1;
        for(int i = 0;i<coins.length;i++){
            for(int j = coins[i];j<dp.length;j++){
                if(dp[j] != 0){
                    if(dp[j-coins[i]] != -1){
                        dp[j] = dp[j]+dp[j-coins[i]];
                    }
                }else{
                    if(dp[j-coins[i]] != 0){
                        dp[j] = dp[j-coins[i]];
                    }
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int k = 11;
        System.out.println(change(k,arr));
    }
}
