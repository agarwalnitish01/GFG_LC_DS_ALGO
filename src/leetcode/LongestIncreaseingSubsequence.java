package leetcode;
public class LongestIncreaseingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
                max = Math.max(max, length[i]);
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(lengthOfLIS(arr));
    }
}
