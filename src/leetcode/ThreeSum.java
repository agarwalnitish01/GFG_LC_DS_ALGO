package leetcode;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);

        HashSet<List<Integer>> set = new HashSet<>();


        // traversing from 0 to array length...
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> hash = new HashMap<>();

            for (int j = i + 1; j < arr.length; j++) {

                if (hash.containsKey(target - arr[i] - arr[j])) {
                    int k = hash.get(target - arr[i] - arr[j]);

                    if (k == i || k == j) continue;

                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        set.add(temp);
                    }
                }

                hash.put(arr[j], j);
            }
        }
        return new ArrayList<>(set);

    }

    public static List<List<Integer>> threeSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > target && nums[i] != nums[i - 1])) {

                int start = i + 1;
                int end = n - 1;

                while (start < end) {

                    if (nums[start] + nums[end] + nums[i] == target) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
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
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {1, -1, -1, 0};

        System.out.println(threeSum(arr, 0));
        System.out.println(threeSum2(arr, 0));
    }
}
