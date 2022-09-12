package leetcode;

import java.util.Arrays;

public class LongestIncreaseingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        Arrays.fill(length, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }
        int max = length[0];
        for (int s : length) {
            if (s > max)
                max = s;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(lengthOfLIS(arr));
        System.out.println(LongestIncreasingSubsequenceLength(arr));
    }

    static int LongestIncreasingSubsequenceLength(int v[]) {
        if (v.length == 0)
            return 0;

        int[] tail = new int[v.length];
        int length = 1;
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] > tail[length - 1]) {
                tail[length++] = v[i];
            } else {
                int idx = Arrays.binarySearch(tail, 0, length - 1, v[i]);

                if (idx < 0)
                    idx = -1 * idx - 1;

                tail[idx] = v[i];
            }
        }
        return length;
    }

}
