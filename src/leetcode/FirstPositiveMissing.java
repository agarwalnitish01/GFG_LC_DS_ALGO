package leetcode;

import java.util.HashSet;

public class FirstPositiveMissing {
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int a : nums) {
            max = Math.max(max, a);
            set.add(a);
        }
        if (max == Integer.MAX_VALUE) {
            max = Integer.MAX_VALUE - 1;
        }
        int min = 1;
        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) {
                min = i;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print(firstMissingPositive(arr));
    }

    public static int firstMissingPositive2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            //check if its positive,in range and not in correct position
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
    }

}
