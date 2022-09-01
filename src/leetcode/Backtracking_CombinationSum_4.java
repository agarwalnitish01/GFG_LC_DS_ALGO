package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking_CombinationSum_4 {
    public static int combinationSum(int[] candidates, int target) {
        int[] result = {0};
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),result);
        return result[0];
    }

    private static void dfs(int[] candidates, int target, ArrayList<Integer> current, int[] result) {
        if( target == 0 ){
            result[0]++;
            return;
        }
        if(target<0){
            return;
        }

        for (int candidate : candidates) {
            current.add(candidate);
            dfs(candidates, target - candidate, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1};
        System.out.println(combinationSum(arr,4));
        System.out.println(combinationSum4(arr,4));
    }


    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=0; i<dp.length; i++){
            for (int data:nums) {
                if (i>=data){
                    dp[i] = dp[i] + dp[i-data] ;
                }
            }
        }
        return dp[target];
    }
}
