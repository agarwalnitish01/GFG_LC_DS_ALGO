package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class K_Generic_Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        ksum(4, nums, 0, new ArrayList<>(), target + 0L, result);
        return result;
    }

    private static void ksum(int k, int[] nums, int j, List<Integer> current, long target, List<List<Integer>> result) {
        if (k == 2) {
            int start = j;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>(current);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
                else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
            return;
        }

        for (int i = j; i <= nums.length - k; i++) {
            if (i != j && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            ksum(k - 1, nums, i + 1, current, target - nums[i], result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};

        System.out.println(fourSum(arr, 0));
    }
}