package leetcode;

public class Maximum_Length_of_Repeated_Subarray {
    public static int findLength(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int ans=0;
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1] ){
                    dp[i][j]= 1+ dp[i-1][j-1];
                    ans=Math.max (ans,dp[i][j] );
                }
                else dp[i][j]=0;
            }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2,1};
        int[] arr2 = {3,2,4,1,7};
        System.out.println(findLength(arr1, arr2));
    }

}

