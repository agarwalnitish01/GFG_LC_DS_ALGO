class MaxSubArray_Product_Sol2 {
    static long maxSubarrayProduct(int arr[], int n) {

        long max_ending_here = arr[0];
        long min_ending_here = arr[0];
        long max = arr[0];

        for (int i = 1; i < n; i++) {
            long temp = Math.max(Math.max(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);
            min_ending_here = Math.min(Math.min(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);
            max_ending_here = temp;
            max = Math.max(max, max_ending_here);
        }

        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr ={-1, -3, -10, 0, 60};
        int n = arr.length;
        System.out.printf("Maximum Sub array product is %d", maxSubarrayProduct(arr, n));
    }
}
