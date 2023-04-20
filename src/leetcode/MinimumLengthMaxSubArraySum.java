package leetcode;


class MinimumLengthMaxSubArraySum {
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

    public static void main(String[] args) {
        int[] a = {1, 4, 45, 6, 0, 19};
        System.out.println(minSubArrayLen(51,a));
    }
}
