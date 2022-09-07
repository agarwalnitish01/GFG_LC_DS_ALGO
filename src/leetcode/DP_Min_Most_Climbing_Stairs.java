package leetcode;

public class DP_Min_Most_Climbing_Stairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]);
            if(i < n ) {
                dp[i] = dp[i] + cost[i];
            }
        }
        //1,100,1,1,1,100,1,1,100,1
        //1,100,2,3,3,103,4,5,104,6
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.print(minCostClimbingStairs(arr));
    }
}
