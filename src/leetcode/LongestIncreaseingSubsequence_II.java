package leetcode;
import java.util.*;

public class LongestIncreaseingSubsequence_II {

    public static int minimumNumberofLongestSubsequence(int[] arr) {
        int n = arr.length;

        int[]dp = new int[n];
        Arrays.fill(dp,1);

        //addition from LIS
        int[]end = new int[n];
        Arrays.fill(end,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){

                if(arr[j]<arr[i]){

                    //addition from LIS
                    if(dp[j]+1==dp[i]) //different subsequence
                        end[i]=end[i] + end[j];
                    if(dp[j]+1>dp[i])//same subsequence
                        end[i]=end[j];

                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        int max = 0;
        for(int num:dp) {
            max = Math.max(max, num);
        }

        //addition from LIS
        int res = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)res+=end[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(minimumNumberofLongestSubsequence(arr));
    }


}
