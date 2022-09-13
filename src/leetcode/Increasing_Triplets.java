package leetcode;

public class Increasing_Triplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 5};
        ;
        System.out.print(increasingTriplet(arr));
        System.out.print(increasingTriplet2(arr));
    }

    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (nums.length < 3) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i < j && j < k) {
                        if (nums[i] < nums[j] && nums[j] < nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {//1,2,3,4,5
        int n = nums.length;
        if (n < 3)
            return false;
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secMin) {
                secMin = num;
            } else if (num > secMin) {
                return true;
            }
        }
        return false;
    }
}
