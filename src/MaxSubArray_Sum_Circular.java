class MaxSubArray_Sum_Circular {

    //kadane
    static int maxSum(int arr[], int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        int max = arr[0], min = arr[0], min_sum = arr[0], max_sum = arr[0];
        for (int i = 1; i < n; i++) {
            max_sum = Math.max( max_sum + arr[i], arr[i]);
            max = Math.max(max, max_sum);

            min_sum = Math.min( min_sum + arr[i], arr[i]);
            min = Math.min(min, min_sum);
        }
        if (min == total) {
            return max;
        }

        // returning the maximum value
        return Math.max(max, total - min);
    }

    // Driver code
    public static void main(String[] args) {
        int a[] = {-3 ,-18 ,-22, -21 ,-17, 16 ,-14 ,28 ,-22};
        int n = 9;

        System.out.println("Maximum circular sum is "
                + maxSum(a, a.length));
    }
}
