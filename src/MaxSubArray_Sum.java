// Java program to print largest contiguous array sum

class MaxSubArray_Sum {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[]) {
        int max = Integer.MIN_VALUE;
        int max_sum = 0;
        for(int i=0; i<a.length; i++){
            max_sum = max_sum + a[i];
            max = Math.max(max, max_sum);
            max_sum = Math.max(0, max_sum);
        }
        return max;
    }
}
