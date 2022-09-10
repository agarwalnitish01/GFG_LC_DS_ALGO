package leetcode;

public class Buy_And_Sell_Stock_II {
    public static void main(String[] args) {
        int[] arr = {7,1,4,2,6,9};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i]-prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }

        return profit;
    }

}
