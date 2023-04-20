package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DP_House_Robber {
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int n = nums.length;
        int [] incl = new int[n+1];

        incl[0] = nums[0];
        incl[1] = nums[1];

        int max = Math.max(nums[0],nums[1]);
        for(int i = 2 ; i< n ; i++){
            incl[i] = Math.max(incl[i-2]+ nums[i],incl[i-1]);
            max = Math.max(incl[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println( rob(Arrays.copyOfRange(arr, 1, arr.length)));
        System.out.println( rob(Arrays.copyOfRange(arr, 0, arr.length-1)));
    }


    public static int robCircle(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }

        if(arr.length == 2){
            return Math.max(arr[0],arr[1]);
        }
        return Math.max(findMoney(Arrays.copyOfRange(arr, 0, arr.length-1)), findMoney(Arrays.copyOfRange(arr, 1, arr.length)));
    }

    public static int findMoney(int[] nums) {

        int n = nums.length;
        int [] incl = new int[n+1];
        int [] excl = new int[n+1];

        incl[0] = nums[0];
        incl[1] = nums[1];

        excl[0] = 0;
        excl[1] = nums[0];
        int max = Math.max(nums[0],nums[1]);
        for(int i = 1 ; i< n-1 ; i++){
            incl[i+1] = excl[i] + nums[i+1];
            max = Math.max(incl[i+1],max);
            excl[i+1] = Math.max(excl[i],incl[i]);
        }
        return max;
    }
}
