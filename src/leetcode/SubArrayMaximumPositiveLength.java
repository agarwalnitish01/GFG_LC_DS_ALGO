package leetcode;

public class SubArrayMaximumPositiveLength {

    public static int getMaxLen(int[] nums) {
        int maxLen = 0;
        int pos = 0;
        int neg = 0;
        for (int i : nums) {
            if (i < 0) {
                int temp = pos;
                pos = neg;
                neg = temp;
                neg = neg + 1;
                if (pos != 0) {
                    pos = pos + 1;
                }
            } else if (i == 0) {
                pos = 0;
                neg = 0;
            } else {
                pos++;
                if (neg != 0) {
                    neg = neg + 1;
                }
            }
            maxLen = Math.max(maxLen, pos);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] a = {9, 5, 8, 2, -6, 4, -3, 0, 2, -5, 15, 10, -7, 9, -2};
        System.out.println("Maximum contiguous sum is " +
                getMaxLen(a));
    }
}
