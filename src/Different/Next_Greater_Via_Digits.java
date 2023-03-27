package Different;

public class Next_Greater_Via_Digits {

    static int[] nextPermutation(int n, int[] arr) {

        if (n == 1)
            return arr;
        int[] res = new int[arr.length];

        // Start from the right most digit and find the first
        // digit that is
        // smaller than the digit next to it.
        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }
        if (i == 0) {
            return arr;
        } else {
            // If there is a possibility of a next greater element
            // Find the smallest digit on right side of (i-1)'th
            // digit that is
            // greater than number[i-1]
            for (int j = n - 1; j >= i; j--) {
                if (arr[i - 1] < arr[j]) {
                    // Swap the found smallest digit i.e. arr[j]
                    // with arr[i-1]
                    int temp = arr[j];
                    arr[j] = arr[i - 1];
                    arr[i - 1] = temp;
                    break;
                }
            }

            int ind = arr.length - 1;

            for (int j = 0; j < i; j++)
                res[j] = arr[j];

            for (int j = i; j < res.length; j++)
                res[j] = arr[ind--];

            return res;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int[] v = {4, 3, 2, 1};
        int[] res;

        res = nextPermutation(v.length, v);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}