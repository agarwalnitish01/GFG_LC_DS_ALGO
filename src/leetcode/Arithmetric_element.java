package leetcode;

public class Arithmetric_element {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,7,8,9};
        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int slices = 0;
        int prev = 0 ;
        for (int i = 2; i < nums.length; i++)
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev++;
                slices = slices + prev;
            } else {
                prev = 0;
            }

        return slices;
    }
}
