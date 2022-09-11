class MaxSubArray_Product {
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
        int[] arr ={1, 3, -10, 100,-20,-10,1, 5};
        int n = arr.length;
        System.out.println("Maximum Sub array product is %d" + maxSubarrayProduct(arr, n));
        System.out.println("Maximum Sub array product is %d" + max(arr, n));
        System.out.println("Maximum Sub array product is %d" + maxProduct(arr));
    }

    static int max(int[] arr, int n) {

        int minVal = arr[0];
        int maxVal = arr[0];

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;

            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
            max = Math.max(max, maxVal);
        }

        return max;
    }

    public static int maxProduct(int[] nums) {

        int product = 1;
        int result = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            product = product * nums[i];
            result = Math.max(product, result);
            if(product==0){
                product =1;
            }
        }


        product = 1;

        for(int i=nums.length-1; i>=0; i--){
            product = product * nums[i];
            result = Math.max(product, result);
            if(product==0){
                product =1;
            }
        }
        return result;
    }
}
