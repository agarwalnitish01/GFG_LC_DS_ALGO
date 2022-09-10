package leetcode;

public class Buy_And_Sell_Stock {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 6, 1, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }

}
