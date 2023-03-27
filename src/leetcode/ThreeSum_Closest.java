package leetcode;

import java.util.Arrays;

public class ThreeSum_Closest {
    public static int threeSum2(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0 ; i < n-2 ; i++){

            int start = i+1;
            int end = n-1;

            while(start < end){
                if(nums[i] + nums[start] + nums[end] == target)
                    return target;

                else if(Math.abs(nums[i] + nums[start] + nums[end] - target) < diff){
                    diff = Math.abs(nums[i] + nums[start] + nums[end] - target);
                    ans = nums[i] + nums[start] + nums[end];
                }

                if (nums[i] + nums[start] + nums[end] < target) {
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                } else {
                    while (start < end  && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    end--;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};

        System.out.println(threeSum2(arr, 1));
    }
}
