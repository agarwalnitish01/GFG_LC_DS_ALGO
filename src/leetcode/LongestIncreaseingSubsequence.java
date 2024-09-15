package leetcode;

import java.util.ArrayList;
import java.util.List;

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
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLIS2(arr));
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }
}
