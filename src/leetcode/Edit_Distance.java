package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edit_Distance {
    public static int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp =new int[n+1][m+1];
        // Deletion base case
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        // insertion base case
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]= dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]){
        String input = "intention";
        String mag = "execution";
        System.out.println(minDistance(input, mag));
    }

}

