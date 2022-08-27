
// Java program to find count of
// subarrays with sum divisible by k.

import java.util.Arrays;

class SubArrayDivisivleByK {

    // Handles all the cases
    // function to find all sub-arrays divisible by k
    // modified to handle negative numbers as well
    static int subCount(int[] arr, int k) {
        int n = arr.length;
        if(n==1){
            if(arr[0]%5==0){
                return 1;
            }
        }
        int[] mod = new int[k];
        Arrays.fill(mod, 0);

        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in mod[] array
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];

            // as the sum can be negative, taking modulo twice
            mod[((cumSum % k) + k) % k]++;
        }

        // Initialize result
        int result = 0;

        // Traverse mod[]
        for (int i = 0; i < k; i++)

            // If there are more than one prefix subarrays
            // with a particular mod value.
            if (mod[i] > 1)
                result +=  mod[0] + (mod[i] * (mod[i] - 1)) / 2;


        return result;
    }

    // Driver code
    public static void main(String[] args) {

        int arr[] = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subCount(arr, k));
    }
}
