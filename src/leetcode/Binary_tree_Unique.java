package leetcode;

public class Binary_tree_Unique {
    public static int numTrees(int n) {
        if(n==0 || n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int j=0;
        for(int i=2;i<=n;i++){
            int num = 0;
            int k = i-1;
            j=0;
            while (j<i && k>=0){
                num = num + dp[j]*dp[k];
                k--;
                j++;
            }
            dp[i] = num;
        }
        return dp[n];
    }

    public static void main(String[] args){
        int result = numTrees(5);

        System.out.println(result);
    }
}
