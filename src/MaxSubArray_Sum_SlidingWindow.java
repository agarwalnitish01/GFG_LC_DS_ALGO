
class MaxSubArray_Sum_SlidingWindow {
    //sliding window
    static int maxSum(int arr[], int n, int k) {
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int max_sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        for (int i = k; i < n; i++) {
            max_sum = max_sum + arr[i] - arr[i - k];
            if (max_sum > max) {
                max = max_sum;
            }
        }

        return max;
    }

    //kadane
    static int maxSum(int arr[], int n) {
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum < arr[i]) {
                sum = arr[i];
            }
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, arr.length, k));
        int[] arr3 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr3, arr3.length));
    }
}
