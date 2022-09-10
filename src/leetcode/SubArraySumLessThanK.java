package leetcode;

public class SubArraySumLessThanK {
    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        System.out.println("Maximum contiguous sum array length is " +
                minSubArrayLen(7, a));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}