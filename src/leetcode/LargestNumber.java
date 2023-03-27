package leetcode;

import java.util.Arrays;

class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] x = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            x[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(x, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : x) {
            sb.append(str);
        }
        String res = sb.toString();

        return res.startsWith("0") ? "0" : res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }
}
