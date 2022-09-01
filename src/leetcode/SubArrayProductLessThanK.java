package leetcode;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] a = {10,5,2,6};
        System.out.println("Maximum contiguous sum is " +
                minSubArrayLen(100, a));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int left = 0, sum = 1;

        for (int i = 0; i < nums.length; i++) {
            sum = sum * nums[i];
            while( left<= i && sum >= target  ) {
                sum = sum / nums[left];
                left++;
            }
            count = count + (i - left + 1);
        }

        return count;
    }
}